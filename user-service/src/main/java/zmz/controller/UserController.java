package zmz.controller;

import constvalue.RedisPrefixConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import response.CommonResponse;
import response.error.BusinessException;
import zmz.constant.TokenHashConst;
import zmz.entity.po.User;
import zmz.service.impl.UserService;

import static zmz.exception.BusinessErrorEnum.PARAMETER_EMPTY_ERROR;
import static zmz.exception.BusinessErrorEnum.USER_NOT_EXIST;

/**
 * @author zhaomanzhou
 * @date 2020/3/15 12:16 上午
 */

@RestController
@RequestMapping("/user/")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/{id}")
    public CommonResponse<User> queryById(@PathVariable Long id) throws BusinessException {
        User user = userService.selectById(id);
        if(user ==null)
            throw  new BusinessException(USER_NOT_EXIST);

        return CommonResponse.success(user);
    }

    @PostMapping("/token")
    public CommonResponse<User> queryByToken(String token) throws BusinessException {
        if(token == null)
            throw new BusinessException(PARAMETER_EMPTY_ERROR);
        User user = (User)redisTemplate.opsForHash().get(RedisPrefixConst.TOKEN_PREFIX + token, TokenHashConst.USER);
        return CommonResponse.success(user);
    }
}
