package com.rendawei.factory;

import com.rendawei.factory.Sender;

public class SmsSender implements Sender {

  @Override
  public void Send() {
    System.out.println("this is sms Sender");
  }
}
