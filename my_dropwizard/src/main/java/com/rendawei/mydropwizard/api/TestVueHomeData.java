package com.rendawei.mydropwizard.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Random;

public class TestVueHomeData {

  @JsonProperty
  public ArrayList<Float> getSensorDataList(){
    ArrayList<Float> sensorDataList = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      sensorDataList.add(new Random().nextFloat());
    }

    return sensorDataList;
  }
}
