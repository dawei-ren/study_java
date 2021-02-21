package com.rendawei.myList;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
* 初始化List
*
* */
public class TestListInit {
  public static void main(String[] args) {
    // 构造List后使用add

    List<String> list1 = new LinkedList<>();
    list1.add("a");
    list1.add("b");
    System.out.println(list1);

    // 使用双括号语法
    List<String> list2 = new LinkedList<String>(){
      private static final long serialVersionUID = -5924383309955514916L;
      {
      add("a");
      add("b");
      add("c");
    }};
    System.out.println(list2);

    // 使用Arrays.asList, 注意，只用这种方法无法再添加元素和删除元素
    List<String> list3 = Arrays.asList("a", "b", "c");
    System.out.println(list3);

    // 使用Stream初始化
    List<String> list4 = Stream.of("a", "b", "c", "d").collect(Collectors.toList());
    System.out.println(list4);
  }
}
