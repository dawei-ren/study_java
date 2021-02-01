package com.rendawei.factory;

public class SendSmsFactory implements Factory {

  @Override
  public Sender produce() {
    return new SmsSender();
  }
}
