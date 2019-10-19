package cn.jx.blog.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import cn.jx.blog.entity.User;
import cn.jx.blog.dao.UserMapper;
import cn.jx.blog.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String username) {
        return userMapper.deleteByPrimaryKey(username);
    }

    @Override
    public User selectByPrimaryKey(String username) {
        return userMapper.selectByPrimaryKey(username);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }
}



