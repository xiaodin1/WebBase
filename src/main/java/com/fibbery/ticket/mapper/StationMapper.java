package com.fibbery.ticket.mapper;

import com.fibbery.framework.mybatis.ui.Page;
import com.fibbery.ticket.bean.Station;

import java.util.List;

public interface StationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Station record);

    int insertSelective(Station record);

    Station selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Station record);

    int updateByPrimaryKeyWithBLOBs(Station record);

    int updateByPrimaryKey(Station record);

    List<Station> list(Page<Station> page);

    List<Station> listAll();
}