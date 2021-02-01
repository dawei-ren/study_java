package com.rendawei.helloword.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

  // 获取全局配置文件的值
  @Value("${hello.name}")
  private String name;

  @ResponseBody  // 返回的数据写个浏览器， 如果是对象，转成json类型
  @RequestMapping("/hello")
  public String hello(){
    return "Hello " + name;
  }
}
