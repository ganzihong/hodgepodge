package com.ganzihong.hodgepodge.controller;

import com.ganzihong.hodgepodge.entity.SysUser;
import com.ganzihong.hodgepodge.model.Result;
import com.ganzihong.hodgepodge.service.UserService;
import com.ganzihong.hodgepodge.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ganzh
 * @description
 * @date 2019/1/13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
@RequestMapping("/getUserById")
    public Result<SysUser> getUserById(Integer id) {
        return ResultUtil.success(userService.queryUserById(id));
    }
}
