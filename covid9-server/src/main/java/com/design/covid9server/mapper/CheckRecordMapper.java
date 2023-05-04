package com.design.covid9server.mapper;

import com.design.covid9server.entity.CheckRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckRecordMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(CheckRecord record);

    CheckRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckRecord record);

    List<CheckRecord> selectCheckRecordByPatentL1Id(CheckRecord checkRecord);

    List<CheckRecord> selectCheckRecordByPatentL3Id(CheckRecord checkRecord);

    int selectMaxOrderNoByPatentId(int patientId, int patientLevel);

}