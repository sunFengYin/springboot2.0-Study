package com.feng.admin.mapper;

import com.feng.admin.entity.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMappper {

    public Account getAccount(Long id);

}
