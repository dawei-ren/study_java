package com.rendawei.factory;

public class SendMailFactory implements Factory {
  @Override
  public Sender produce() {
    return new MailSender();
  }
}
