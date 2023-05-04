package com.design.covid9server.mapper;

import com.design.covid9server.entity.Leader;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Leader record);

    Leader selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Leader record);

    List<Leader> selectLeaderByPage(int start, int pageSize);

    long selectLeaderCountAll();
}