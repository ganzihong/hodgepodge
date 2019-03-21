package com.ganzihong.hodgepodge.controller;

import com.ganzihong.hodgepodge.model.Result;
import com.ganzihong.hodgepodge.utils.ResultUtil;
import com.ganzihong.hodgepodge.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author ganzh
 * @description
 * @date 2019/1/13
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/getUserById")
    public Result<User> getUserById(Integer id) {
        User user = new User();
        user.setId(id);
        user.setName("A");
        user.setCreateTime(new Date());
        return ResultUtil.success(user);
    }
}
