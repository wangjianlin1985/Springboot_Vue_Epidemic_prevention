package com.design.covid9server.server;

import com.design.covid9server.entity.SysUser;

import java.util.List;

public interface UserService {

    List<SysUser> selectUserByPage(int currPage);

    long selectUserCountAll();

    int updateUserById(SysUser User);

    int deleteUserById(int id);

    int saveUser(SysUser user);

    SysUser logon(SysUser sysUser);

    long checkAccount(SysUser sysUser);
}
