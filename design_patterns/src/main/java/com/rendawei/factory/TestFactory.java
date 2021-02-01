package com.rendawei.factory;

public class TestFactory {

  public static void main(String[] args) {

//    可以通过传入不同的工厂类，制造出不同的对象，
    Factory factory = new SendMailFactory();
    Sender sender = factory.produce();
    sender.Send();
  }
}
