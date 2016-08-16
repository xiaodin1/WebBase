package com.fibbery.framework.controller;

import com.fibbery.framework.constant.ResultConstant;
import com.fibbery.framework.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 通用controller
 * PATH 获取列表
 * GET 获取单个对象
 * PUT 更新操作
 * POST 新增操作
 * DELETE 删除操作
 * Created by nenghua_jiang  on 2016/7/8.
 */
public class BaseController {
    protected final Logger log = LoggerFactory.getLogger(getClass());//子类可直接用此log对象打印日志
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    @ModelAttribute
    public void setReqAndResp(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
        this.request = request;
        this.response = response;
        this.session = session;
    }

    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip.trim())) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip.trim())) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip.trim())) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static ResultInfo success(Object obj){
        ResultInfo info = new ResultInfo();
        info.setResult(obj);
        info.setCode(ResultConstant.SUCCESS);
        return info;
    }
}
