package com.design.covid9server.server.impl;

import com.design.covid9server.entity.SysUser;
import com.design.covid9server.mapper.SysUserMapper;
import com.design.covid9server.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final int PAGESIZE = 10;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> selectUserByPage(int currPage) {
        int start = PAGESIZE * (currPage - 1);
        return sysUserMapper.selectSysUserByPage(start, 10);
    }

    @Override
    public long selectUserCountAll() {
        return sysUserMapper.selectSysUserCountAll();
    }

    @Override
    public int updateUserById(SysUser sysUser) {
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public int deleteUserById(int id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int saveUser(SysUser user) {
        return sysUserMapper.insert(user);
    }

    @Override
    public SysUser logon(SysUser sysUser) {
        return sysUserMapper.logon(sysUser);
    }

    @Override
    public long checkAccount(SysUser user) {
        return sysUserMapper.checkAccount(user);
    }
}
