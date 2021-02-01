package com.rendawei.helloword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
* @SpringBootApplication 用来标注这个类是一个主程序类
*
* */
@SpringBootApplication
public class HelloWorldMainApplication {
  public static void main(String[] args) {
    // Spring应用启动
    SpringApplication.run(HelloWorldMainApplication.class, args);
  }
}
