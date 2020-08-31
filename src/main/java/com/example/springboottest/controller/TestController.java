package com.example.springboottest.controller;

import com.example.springboottest.serviceApi.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboottest
 * @description: test的Controller
 * @Auther: zhengchuan
 * @Createdate: 2020-08-27-16-57
 */

//@RestController等同于@Controller+@ResponseBody
@RestController
public class TestController {
    @Autowired
    TestService testService;

    @RequestMapping(value = "/getTestService",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String getTestService(){
        testService.sysTest();
        return "aaa";
    }

}
