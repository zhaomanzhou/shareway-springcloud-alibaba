package zmz.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zmz.entity.po.User;
import zmz.mapper.UserMapper;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author zhaomanzhou
 * @date 2020/3/15 11:43 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {


    @Resource
    private UserMapper userMapper;


    @Test
    public void testMapper()
    {
        User user = userMapper.selectByPrimaryKey((long) 1);
        System.out.println(user);
    }

}
