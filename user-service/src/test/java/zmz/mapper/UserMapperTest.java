package zmz.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import zmz.entity.po.User;

import javax.annotation.Resource;
import javax.sql.DataSource;

import static org.junit.Assert.*;

/**
 * @author zhaomanzhou
 * @date 2020/3/14 9:31 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@MapperScan("zmz.mapper")
public class UserMapperTest {

    @Resource
    private DataSource dataSource;

    @Resource
    private UserMapper userMapper;

    @Test
    public void testMapper()
    {

        User user = new User();
        user.setTel("1313313");
        System.out.println(userMapper.insert(user));



    }

}
