package com.design.covid9server.mapper;

import com.design.covid9server.dto.PatientL2Dto;
import com.design.covid9server.entity.PatientL3;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientL3Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PatientL3 record);

    PatientL3 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PatientL3 record);

    List<PatientL3> selectPatientL3ByPage(int start, int pageSize);

    long selectPatientL3CountAll();

    List<PatientL2Dto> selectCountByGender();

    List<PatientL2Dto> selectCountByAge();

}