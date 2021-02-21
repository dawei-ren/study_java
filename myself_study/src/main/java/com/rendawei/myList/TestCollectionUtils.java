package com.rendawei.myList;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/*
*
* CollectionUtils 工具类 在真实的项目中，可以使你的代码更加简洁和安全
*
*   <dependency>
        <groupId>org.apache.commons</groupId>
        <artifactId>commons-collections4</artifactId>
        <version>4.3</version>
    </dependency>
*
* */
public class TestCollectionUtils {
  public static void main(String[] args) {

    /*
    *
    * 空安全检查指定的集合是否为空
    *
    *
    * CollectionUtils.isEmpty(list)  可以判断集合为空，或者集合为null时，返回true
    *
    * */

    List<String> list3 = Arrays.asList("a", "b", "c");
    List<String> list4 = null;
    System.out.println(CollectionUtils.isEmpty(list3));
    System.out.println(CollectionUtils.isEmpty(list4));

  }
}
