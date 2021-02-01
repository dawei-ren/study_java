package com.rendawei.yudipu;

import java.util.ArrayList;
import java.util.Arrays;

public class ParticleParse {

  public static void main(String[] args) {
    String particleString = "00a8 bf95 04a6 0080 bf91 06a6 bf91 00a4 0680 bf91 08a4 bf91 0aa4 bf8f 0aa4 " +
        "bf8f 0aa4 bf8f 0aa4 bf8f 0aa4 bf8f 0ba3 bf8f 0ca2 bf8f 0ca2 bf8f 0ca2 bf8f 0ca2 bf8f 0ca2 bf8f " +
        "0ca2 bf8f 0ca2 bf8f 0ca2 bf8f 0ca2 bf8f 0ca2 bf8f 0ca2 bf8f 0ca2 bf8f 0ca2 bf8f 0ba3 bf8f 0ba3 " +
        "bf8f 0aa3 bf90 0aa3 bf90 09a4 bf90 09a4 bf90 08a4 bf91 07a5 bf91 06a5 bf92 05a6 bf92 03a7 bf93 " +
        "00a8 bf95 55aa 00c5 007c 007c 007b 0008 08f8 22b5";

    // 获取双字节列表，每一个元素是一个word，也就是两个字节
    String[] particleWordList = particleString.split(" ");
    // 将数组转化为ArrayList
    ArrayList<String> particleWords = new ArrayList<>(Arrays.asList(particleWordList));
    System.out.println(particleWords);

    // 分割粒子信息为切片信息和描述信息，描述信息为后7个word，切片信息和描述信息以55aa分割
    // 获取粒子切片信息
    ArrayList<String> sliceWords = new ArrayList<>(particleWords.subList(0, (particleWords.size()-(7+1))));
    System.out.println(sliceWords);
    // 获取粒子描述信息
    ArrayList<String> metaDataWords = new ArrayList<>(particleWords.subList((particleWords.size()-7), particleWords.size()));
//    System.out.println(metaDataWords);

    for (String eachWords : sliceWords) {
      System.out.println(eachWords);
    }
  }
}
