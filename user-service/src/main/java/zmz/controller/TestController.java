package zmz.controller;

import constvalue.RedisPrefixConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import response.CommonResponse;
import response.error.BusinessException;
import zmz.constant.TokenHashConst;
import zmz.entity.po.User;
import zmz.exception.BusinessErrorEnum;
import zmz.mapper.UserMapper;
import zmz.service.UserService;
import zmz.util.Jwtutil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static zmz.exception.BusinessErrorEnum.USER_NOT_EXIST;

/**
 * @author zhaomanzhou
 */

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {


    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Value("${token.expiration}")
    private int expiration;

    @RequestMapping("/test")
    public CommonResponse<String> test()
    {
        User user = new User();
        user.setTel("31313");
        userMapper.insert(user);
        return CommonResponse.success("String");
    }


    @RequestMapping("/error1")
    public CommonResponse<String> error() throws BusinessException {
        throw new BusinessException(USER_NOT_EXIST);
    }

    @GetMapping("/{id}")
    public CommonResponse<String> fakeLogin(@PathVariable Long id) throws BusinessException {
        User user = userService.selectById(id);
        if(user == null)
        {
            throw new BusinessException(USER_NOT_EXIST);
        }

        log.info("用户为{}", user);
        //存到redis里
        Map<String, Object> tokenMap = new HashMap<>();
        tokenMap.put("nickname", user.getNickName());
        tokenMap.put("openid", user.getOpenId());
        String token = Jwtutil.generateToken(tokenMap);
        redisTemplate.opsForHash().put(RedisPrefixConst.TOKEN_PREFIX+token, TokenHashConst.USER, user);
        redisTemplate.expire(RedisPrefixConst.TOKEN_PREFIX+token, expiration, TimeUnit.MINUTES);

        return CommonResponse.success(token);
    }
}
