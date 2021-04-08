package com.rendawei.optimizeCode;

import java.util.ArrayList;

public class OptimizeAboutIfAndElse {
  public String getMin(String a, String b){
    if (a.length() < b.length()){
      return a;
    } else {
      return b;
    }
  }

  /**
   * 使用三目运算符可以简化条件判断
   */
  public String getMinOptimize(String a, String b){
    return a.length() < b.length() ? a:b;
  }


  public void moreCondition(ArrayList<String> list){
    if (list.size() > 2){
      list.forEach(System.out::println);
      list.add("end");
    }
  }

  /**
   *
   * 使用如下优化方法可以减少大量代码的缩进
   */
  public void optimizeMoreCondition(ArrayList<String> list){
    if (list.size() <= 2){
      return;
    }
    list.forEach(System.out::println);
    list.add("end");
  }

}
