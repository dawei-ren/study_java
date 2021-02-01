package com.rendawei.myExcel;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TestExcelTest {

  @Test
  public void testWriteExcel () throws IOException {
    TestExcel testExcel = new TestExcel();
    testExcel.createExcel();
  }

}