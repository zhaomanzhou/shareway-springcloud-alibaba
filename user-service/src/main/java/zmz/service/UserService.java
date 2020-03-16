package zmz.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zmz.entity.po.User;
import zmz.mapper.UserMapper;

import javax.annotation.Resource;

@Service
public class UserService
{
    @Resource
    private UserMapper userMapper;

    /**
     * 根据openid判断此人是否登陆过
     * @param openId
     * @return
     */
    public boolean hasLogined(String openId)
    {
        User user = userMapper.selectByOpenId(openId);
        if(user == null)
            return false;
        else
            return true;
    }

    @Transactional
    public void addUser(User u)
    {
        userMapper.insertSelective(u);
    }

    public User selectById(Long id)
    {
        return userMapper.selectByPrimaryKey(id);
    }

    public User selectByOpenId(String openId)
    {
        return userMapper.selectByOpenId(openId);
    }

    public Long selectIdByOpenid(String openId)
    {
        return userMapper.selectIdByOpenid(openId);
    }
}
