package com.design.covid9server.mapper;

import com.design.covid9server.dto.PatientL2Dto;
import com.design.covid9server.entity.PatientL1;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientL1Mapper {

    int deleteByPrimaryKey(Integer id);

    int insert(PatientL1 record);

    PatientL1 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PatientL1 record);

    List<PatientL1> selectByPage(int start, int pageSize);

    long selectCountAll();

    List<PatientL2Dto> selectCountByGender();

    List<PatientL2Dto> selectCountByAge();
}