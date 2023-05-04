package com.design.covid9server.mapper;

import com.design.covid9server.entity.News;
import com.design.covid9server.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    List<SysUser> selectSysUserByPage(int start, int pageSize);

    long selectSysUserCountAll();

    SysUser logon(SysUser sysUser);

    long checkAccount(SysUser user);
}