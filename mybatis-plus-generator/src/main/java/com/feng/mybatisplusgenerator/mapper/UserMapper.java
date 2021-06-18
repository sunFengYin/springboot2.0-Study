package com.feng.mybatisplusgenerator.mapper;

import com.feng.mybatisplusgenerator.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sunfengyin
 * @since 2021-06-18
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user where id=#{id}")
    User getbyId(Long id);

    List<User> myFindAllUser();
}
