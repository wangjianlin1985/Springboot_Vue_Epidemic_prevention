package com.design.covid9server.controller;

import com.design.covid9server.entity.SysUser;
import com.design.covid9server.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000")
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping("/selectUser")
    public Map selectUser(@RequestBody SysUser User) {
        Map map = new HashMap();
        map.put("data", userService.selectUserByPage(User.getCurrPage()));
        map.put("count", userService.selectUserCountAll());
        return map;
    }

    @RequestMapping("/saveUser")
    public int saveUser(@RequestBody SysUser User) {
        return userService.saveUser(User);
    }

    @RequestMapping("/updateUserById")
    public int updateUserById(@RequestBody SysUser User) {
        return userService.updateUserById(User);
    }

    @RequestMapping("/deleteUserById")
    public int deleteUserById(@RequestParam("id") int id) {
        return userService.deleteUserById(id);
    }

    @RequestMapping("/logon")
    public SysUser logon(@RequestBody SysUser User) {
        return userService.logon(User);
    }

    @RequestMapping("/checkAccount")
    public long checkAccount(@RequestBody SysUser sysUser) {
        return userService.checkAccount(sysUser);
    }
}
