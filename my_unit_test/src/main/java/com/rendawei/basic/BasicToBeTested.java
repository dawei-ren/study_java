package com.rendawei.basic;

import java.util.ArrayList;
import java.util.List;

public class BasicToBeTested {
  private Boolean state;

  public int add(int a, int b){
    return a + b;
  }

  public List<String> addArrayList(List<String> listA, List<String> listB){
    List<String> res = new ArrayList<String>();
    res.addAll(listA);
    res.addAll(listB);
    return res;
  }

  private int privateAdd(int a, int b){
    return a + b;
  }

  public void changeState(int intState){
    state = intState != 0;
  }

  public Boolean getState() {
    return state;
  }

  public void failed() throws Exception {
    throw new Exception("aaa");
  }
}
