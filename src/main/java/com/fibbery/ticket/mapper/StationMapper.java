package com.fibbery.ticket.mapper;

import com.fibbery.framework.mybatis.ui.Page;
import com.fibbery.ticket.bean.Station;

public interface StationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Station record);

    int insertSelective(Station record);

    Station selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Station record);

    int updateByPrimaryKeyWithBLOBs(Station record);

    int updateByPrimaryKey(Station record);

    void listAll(Page<Station> page);
}