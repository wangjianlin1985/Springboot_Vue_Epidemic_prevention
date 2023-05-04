package com.design.covid9server.mapper;

import com.design.covid9server.dto.PatientL2Dto;
import com.design.covid9server.entity.PatientL2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientL2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PatientL2 record);

    PatientL2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PatientL2 record);

    List<PatientL2> selectPatientL2ByPage(int start, int pageSize);

    long selectPatientL2CountAll();

    List<PatientL2Dto> selectCountByFromCity();

    List<PatientL2Dto> selectCountByGender();

    List<PatientL2Dto> selectCountByAge();
}