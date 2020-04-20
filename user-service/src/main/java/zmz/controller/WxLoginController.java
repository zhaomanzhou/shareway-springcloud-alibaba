package zmz.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import constvalue.RedisPrefixConst;
import constvalue.WxConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import zmz.constant.TokenHashConst;
import zmz.entity.po.User;
import zmz.service.impl.UserService;
import zmz.util.HttpClientUtil;
import zmz.util.Jwtutil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
@Slf4j
public class WxLoginController
{

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Value("${token.expiration}")
    private int expiration;


    @PostMapping("/wxLogin")
    @ResponseBody
    public Map<String, String> wxLogin(@RequestParam("code") String code, @RequestParam("nickname") String nickName,
                                    @RequestParam("gender") Integer gender, @RequestParam("avatarUrl") String avatarUrl
                                    ) throws IOException
    {
        log.info(code);
        Map<String, String> map = new HashMap<>();
        map.put("appid", WxConst.appid);
        map.put("secret", WxConst.appsecret);
        map.put("js_code", code);
        map.put("grant_type", "authorization_code");
        String wxResult = HttpClientUtil.doGet(WxConst.Code2SessionUrl, map);
        //{"session_key":"nnEQG35eCBroMaolPVgloQ==","openid":"onNvb4pB3A1Oletx8UbTK-B_LVk8"}
        log.info("WxResult {}", wxResult);


        //解析返回结果
        ObjectMapper om = new ObjectMapper();
        JsonNode jsonNode = om.readTree(wxResult);
        String session_key = jsonNode.get("session_key").asText();
        String openid = jsonNode.get("openid").asText();


        //检查是否为第一次登陆
        User user = userService.selectByOpenId(openid);

        //第一次登陆
        if(user == null)
        {
            log.info("第一次登陆");
            user = new User();
            user.setOpenId(openid);
            user.setNickName(nickName);
            user.setGender(Byte.parseByte(gender.toString()));
            user.setHeadPhoto(avatarUrl);
            userService.addUser(user);
        }

        log.info("用户为{}", user);
        //存到redis里
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("nickname", nickName);
        tokenMap.put("openid", openid);
        String token = Jwtutil.generateToken(tokenMap);
        redisTemplate.opsForHash().put(RedisPrefixConst.TOKEN_PREFIX+token, TokenHashConst.USER, user);
        redisTemplate.expire(RedisPrefixConst.TOKEN_PREFIX+token, expiration, TimeUnit.MINUTES);


        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("token", token);
        resultMap.put("user_id", userService.selectIdByOpenid(openid) + "");

        return resultMap;

    }

}
