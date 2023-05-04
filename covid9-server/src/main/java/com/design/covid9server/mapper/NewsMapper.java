package com.design.covid9server.mapper;

import com.design.covid9server.entity.News;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(News record);

    News selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(News record);

    List<News> selectNewsByPage(int start, int pageSize);

    long selectNewsCountAll();

}