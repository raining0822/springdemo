package com.hiersun.xzkp.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * date 2016/10/25 11:33
 *
 * @author Leon yang_xu@hiersun.com
 * @version V1.0
 */
@RestController
public class UserController {

    @RequestMapping("/user/index")
    public String index(){
        return "使用SpringBoot开发的第一个rest风格控制器！";
    }
}
