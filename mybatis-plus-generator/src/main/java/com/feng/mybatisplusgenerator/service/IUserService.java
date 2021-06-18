package com.feng.mybatisplusgenerator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.feng.mybatisplusgenerator.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sunfengyin
 * @since 2021-06-18
 */
public interface IUserService extends IService<User> {

    User getbyId(Long id);

    List<User> myFindAllUser();
}
