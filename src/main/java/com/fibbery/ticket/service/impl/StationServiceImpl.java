package com.fibbery.ticket.service.impl;

import com.fibbery.framework.exception.BizException;
import com.fibbery.framework.mybatis.ui.Page;
import com.fibbery.ticket.bean.Station;
import com.fibbery.ticket.mapper.StationMapper;
import com.fibbery.ticket.service.StationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by jiangnenghua on 16/8/25.
 */
@Service("StationService")
public class StationServiceImpl implements StationService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected StationMapper stationMapper;

    @Override
    public void add(Station record) throws BizException {

    }

    @Override
    public void delete(String key) throws BizException {

    }

    @Override
    public void modify(Station record) throws BizException {

    }

    @Override
    public Station get(String key) throws BizException {
        return null;
    }

    @Override
    public void deleteAll() throws BizException {
    }

    @Override
    public void listAll(Page<Station> page) throws BizException {
        stationMapper.listAll(page);
    }

    @Override
    public boolean isValid(Station record) throws BizException {
        return false;
    }
}
