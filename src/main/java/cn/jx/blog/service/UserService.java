package cn.jx.blog.service;

import cn.jx.blog.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


    int insert(User record);

    int insertSelective(User record);

    int deleteByPrimaryKey(String username);

    User selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}



