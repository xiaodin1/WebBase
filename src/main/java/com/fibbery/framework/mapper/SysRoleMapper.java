package com.fibbery.framework.mapper;

import com.fibbery.framework.bean.SysRole;
import com.fibbery.framework.mybatis.ui.Page;

import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> list(Page<SysRole> page);

    List<SysRole> listAll();

    Long isValid(SysRole record);

    void deleteAll();
}