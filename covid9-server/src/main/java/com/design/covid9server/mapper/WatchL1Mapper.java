package com.design.covid9server.mapper;

import com.design.covid9server.entity.WatchL1;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchL1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WatchL1 record);

    WatchL1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WatchL1 record);

    WatchL1 selectByPatientId(int patientId);

}