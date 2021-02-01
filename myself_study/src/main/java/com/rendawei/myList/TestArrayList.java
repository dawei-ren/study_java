package com.rendawei.myList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TestArrayList {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();

    list.add("a1");
    list.add("a2");
    list.add("a2");
    list.add("a3");
    list.add("a3");
    list.add("a3");
    list.add("a4");
    list.add("a1");

    System.out.println("删除数组中的一个");
    System.out.println(list.toString());
    list.forEach(e -> {
      if (e.equals("a4")){
        list.remove(e);
      }
    });
    System.out.println(list);



    System.out.println("使用普通的for循环: 如果需要操作index，则需要使用这种循环");
    for (int i = 0; i < list.size(); i++) {
      System.out.println(i);
      System.out.println(list.get(i));
    }

    System.out.println("使用简化的for循环: for each");
    for (String s : list) {
      System.out.println(s);
    }

    System.out.println("使用最简化的for循环： list.forEach");
    list.forEach(each ->{
      System.out.println(each);
      System.out.println(each);
    });

    list.forEach(System.out::println);


    System.out.println("使用Iterator循环");
    Iterator<String> it = list.iterator();
    while (it.hasNext()){
      System.out.println(it.next());
    }



    System.out.println("循环列表，对比相邻的两个数据，如果相同，删除其中一个");
    for (int j = list.size() - 1; j > 0; j--) {
      if (list.get(j).equals(list.get(j-1))){
        list.remove(j);
      }
    }

    System.out.println(list);
  }
}



