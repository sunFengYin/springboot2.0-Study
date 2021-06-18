package com.feng.admin.mapper;

import com.feng.admin.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {
    @Select("select * from city where id=#{id}")
     City getById(Long id);
}
