package com.feng.mybatisplusgenerator.service.impl;

import com.feng.mybatisplusgenerator.entity.User;
import com.feng.mybatisplusgenerator.mapper.UserMapper;
import com.feng.mybatisplusgenerator.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sunfengyin
 * @since 2021-06-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User getbyId(Long id) {
        return userMapper.getbyId(id);
    }

    @Override
    public List<User> myFindAllUser() {
        return userMapper.myFindAllUser();
    }
}
