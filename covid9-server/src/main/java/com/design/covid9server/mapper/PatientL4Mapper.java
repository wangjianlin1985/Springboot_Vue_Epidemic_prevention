package com.design.covid9server.mapper;

import com.design.covid9server.entity.PatientL3;
import com.design.covid9server.entity.PatientL4;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientL4Mapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PatientL4 record);

    PatientL4 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PatientL4 record);

    List<PatientL4> selectPatientL4ByPage(int start, int pageSize);

    long selectPatientL4CountAll();

}