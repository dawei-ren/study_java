package com.rendawei.myMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashMapTest {
  public Map<String, List<String>> map = new HashMap<>();

  public Map<String, List<String>> normalGetValue(String key){

    // 获取值，如果值为空，创建值并赋值
//    List<String> earliest = map.get(key);
//    if (earliest == null){
//       List<String> list = new LinkedList<>();
//       map.put(key, list);
//    }
//
//    map.get(key).add("One");

    // 判断是否存在，如果存在，更新，如果不存在，添加
    if (map.containsKey(key)){
      map.get(key).add("one");
    } else {
      List<String> list = new LinkedList<>();
      map.put(key, list);
    }


    return map;
  }

  public Map<String, List<String>> useComputeIfAbsent(String key){
    // 获取key的值，如果没有，自动创建并返回
    List<String> list = map.computeIfAbsent(key, k2 -> new LinkedList<>());
    list.add("Two");
    return map;
  }

}
