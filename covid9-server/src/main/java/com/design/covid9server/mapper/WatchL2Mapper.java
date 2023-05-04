package com.design.covid9server.mapper;

import com.design.covid9server.entity.WatchL2;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchL2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WatchL2 record);

    WatchL2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WatchL2 record);

    WatchL2 selectByPatientId(int patientId);

}