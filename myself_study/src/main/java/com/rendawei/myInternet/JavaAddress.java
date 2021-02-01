package com.rendawei.myInternet;

import java.net.InetSocketAddress;

public class JavaAddress {
  public static void main(String[] args) {
    InetSocketAddress isa = new InetSocketAddress("localhost", 6666);
    System.out.println(isa.getAddress());
    System.out.println(isa.getHostName());
    System.out.println(isa.getPort());
  }
}
