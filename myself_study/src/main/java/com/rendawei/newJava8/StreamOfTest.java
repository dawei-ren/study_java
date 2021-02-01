package com.rendawei.newJava8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
*
* Stream API
*     步骤： 获取流 -> 中间处理 ->  终止操作
*
*
*     获取流：
*       通过Collection系列提供的 stream()
*         arrayList.stream()
*       通过Stream.of() 方法
*         Stream.of("aaaaa","bbbbb")
*       通过Arrays 中的静态方法
*         Arrays.stream(array)
*       获取无限流
*         Stream.iterate(0, (x) -> x+2)   迭代方法获取无限流
*         Stream.generate(() -> Math.random())  生成方法获取无线流
*
*     中间操作：
*       .filter   过滤
*       .limit    截断
*       .map      挨个操作
*
*     终止操作
*       .forEach   循环
*       .count     求总数
*       .reduce    归约
*       .collect(Collectors)   收集  Collectors为收集器
*
*
*
*
*
* */

public class StreamOfTest {

  public static void main(String[] args) {
    List<String> res = Stream.of("aaaaa","bbbbb").map(f -> f.replace("a", "c")).collect(Collectors.toList());
    for (int i = 0; i < res.size(); i++) {
      System.out.println(res);
    }

    res.forEach(System.out::println);
  }
}
