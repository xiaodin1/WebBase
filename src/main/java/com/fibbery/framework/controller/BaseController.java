package com.fibbery.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 通用controller
 * Created by Administrator on 2016/7/8.
 */
@Controller("/baseController")
public class BaseController {

    @ResponseBody
    @RequestMapping("/init")
    public String init() {
        return null;
    }
}
