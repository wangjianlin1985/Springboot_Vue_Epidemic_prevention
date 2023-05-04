package com.design.covid9server.mapper;

import com.design.covid9server.entity.WatchL3;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchL3Mapper {

    int deleteByPrimaryKey(Integer id);

    int insert(WatchL3 record);

    WatchL3 selectByPrimaryKey(Integer id);

    WatchL3 selectByPatientId(Integer id);

    int updateByPrimaryKeySelective(WatchL3 record);

}