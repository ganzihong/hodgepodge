package com.ganzihong.hodgepodge.controller;

import com.ganzihong.hodgepodge.config.MyConfigBean;
import com.ganzihong.hodgepodge.model.Result;
import com.ganzihong.hodgepodge.utils.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ganzh
 * @description
 * @date 2019/1/13
 */
@RestController

@EnableConfigurationProperties({MyConfigBean.class})
public class MyConfigController {

    @Autowired
    MyConfigBean myConfigBean;

    @RequestMapping("/myconfig")
    public Result<MyConfigBean> getMyconfig() {
        MyConfigBean myConfigBean2 = new MyConfigBean();
        BeanUtils.copyProperties(myConfigBean,MyConfigBean.class);
        return ResultUtil.success(myConfigBean2);
    }
}
