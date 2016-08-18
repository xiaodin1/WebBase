package com.fibbery.framework.controller;

import com.fibbery.framework.bean.SysRole;
import com.fibbery.framework.exception.BizException;
import com.fibbery.framework.mybatis.ui.Page;
import com.fibbery.framework.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 角色控制类 RESTful 实例
 * Created by jiangnenghua on 2016/8/16.
 */
@Controller
@RequestMapping("/role")
public class SysRoleController extends BaseController {

    @Autowired
    SysRoleService roleService;

    @RequestMapping(method = RequestMethod.PATCH)
    @ResponseBody
    public Page<SysRole> list() throws BizException {
        Page<SysRole> page = new Page<SysRole>();
        roleService.listAll(page);
        return page;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo get(@PathVariable("id")String id) throws BizException{
       return success(roleService.get(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultInfo delete(@PathVariable("id")String id) throws BizException {
        roleService.delete(id);
        return success(null);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo add(@RequestBody SysRole role) throws BizException {
        roleService.add(role);
        return success(null);
    }
}
