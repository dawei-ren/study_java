package com.rendawei.myLog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog {
  private static final Logger logger = LoggerFactory.getLogger(TestLog.class);
  public static void main(String[] args) {

    for (int i = 0; i < 100; i++) {
      logger.error("{}", i);
    }


  }
}
