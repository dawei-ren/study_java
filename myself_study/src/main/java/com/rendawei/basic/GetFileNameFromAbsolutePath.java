package com.rendawei.basic;

import java.io.File;
import java.util.Arrays;

public class GetFileNameFromAbsolutePath {
  public static void main(String[] args) {


    String fName = "/User/David/Desktop/local_homeDir/yudipu/2020-08-23-00-00-13.yudipu.raw";
    String fName2 = "C:\\Users\\David\\Desktop\\test\\2020-08-23-00-00-13.yudipu.raw";


    fName = fName.trim();
    String[] temp = fName.split("\\\\|/|[.]");
    String[] temp2 = fName2.split("\\\\|/|[.]");



    System.out.println(Arrays.toString(temp));
    System.out.println(temp[temp.length-3]);

    System.out.println(Arrays.toString(temp2));
    System.out.println(temp2[temp2.length-3]);






//    File tempFile = new File(fName.trim());
//    String fileName = tempFile.getName();
//    System.out.println(fileName);
  }
}
