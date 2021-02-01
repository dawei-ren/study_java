package com.rendawei.myMap;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class HashMapTestTest {

  @Test
  public void testNormal(){
    HashMapTest hashMapTest = new HashMapTest();
    Map<String, List<String>> res = hashMapTest.normalGetValue("k1");
    System.out.println(res.toString());
  }

  @Test
  public void testComputeIfAbsent(){
    HashMapTest hashMapTest = new HashMapTest();
    Map<String, List<String>> res = hashMapTest.useComputeIfAbsent("k2");
    System.out.println(res.toString());
  }

}