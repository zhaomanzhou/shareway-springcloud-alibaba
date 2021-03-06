package zmz.mapper;


import zmz.entity.po.User;

public interface UserMapper
{
    int deleteByPrimaryKey(Long id);

    Long selectIdByOpenid(String openId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByOpenId(String openId);
}