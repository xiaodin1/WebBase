package com.fibbery.ticket.controller;

import com.fibbery.framework.controller.BaseController;
import com.fibbery.framework.controller.ResultInfo;
import com.fibbery.framework.exception.BizException;
import com.fibbery.ticket.bean.Station;
import com.fibbery.ticket.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public ResultInfo listAll() throws BizException{
        List<Station> rows = stationService.listAll();
        return  success(rows);
    }

}
