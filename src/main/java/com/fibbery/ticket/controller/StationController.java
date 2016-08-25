package com.fibbery.ticket.controller;

import com.fibbery.framework.controller.BaseController;
import com.fibbery.framework.exception.BizException;
import com.fibbery.framework.mybatis.ui.Page;
import com.fibbery.ticket.bean.Station;
import com.fibbery.ticket.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jiangnenghua on 16/8/25.
 */

@Controller
@RequestMapping("/station")
public class StationController extends BaseController {

    @Autowired
    private StationService stationService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.PATCH)
    public Page<Station> listAll() throws BizException{
        Page<Station> page = new Page<Station>();
        stationService.listAll(page);
        return page;
    }

}
