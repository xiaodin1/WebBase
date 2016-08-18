package com.fibbery.framework.service.impl;

import com.fibbery.framework.bean.SysRole;
import com.fibbery.framework.constant.ResultConstant;
import com.fibbery.framework.exception.BizException;
import com.fibbery.framework.mapper.SysRoleMapper;
import com.fibbery.framework.mybatis.ui.Page;
import com.fibbery.framework.service.SysRoleService;
import com.fibbery.framework.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Created by jiangnenghua on 2016/8/16.
 */

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public void add(SysRole record) throws BizException {
        if(!isValid(record)) throw new BizException(ResultConstant.FAIL,"存在相同的名称");
        roleMapper.insertSelective(record);
    }

    @Override
    public void delete(String key) throws BizException {
        roleMapper.deleteByPrimaryKey(Long.parseLong(StringUtils.cnull(key)));
    }

    @Override
    public void modify(SysRole record) throws BizException {
        if(!isValid(record)) throw new BizException(ResultConstant.FAIL,"存在相同的名称");
        roleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public SysRole get(String key) throws BizException {
        return roleMapper.selectByPrimaryKey(Long.parseLong(StringUtils.cnull(key)));
    }

    @Override
    public void deleteAll() throws BizException {
        roleMapper.deleteAll();
    }

    @Override
    public void listAll(Page<SysRole> page) {
        List<SysRole> list = roleMapper.listAll(page);
        page.setRows(list);
    }


    @Override
    public boolean isValid(SysRole record) throws BizException {
        if(StringUtils.isEmpty(record.getName())) throw new BizException(ResultConstant.FAIL,"名称不能为空!");
        return roleMapper.isValid(record) > 0;
    }


}
