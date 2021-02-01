package com.rendawei.factory;

public class MailSender implements Sender {

  @Override
  public void Send() {
    System.out.println("this is a mail sender");
  }
}
