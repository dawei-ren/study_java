package com.rendawei.mockito.arguments;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class MyArgumentCaptorTest {

  @Test
  public void argumentCaptorTest() {
    List mock = Mockito.mock(List.class);
    mock.add("John");

    // 注意，获取参数一定要在函数调用后面，不然会报错
    ArgumentCaptor argument = ArgumentCaptor.forClass(String.class);
    Mockito.verify(mock).add(argument.capture());
    assertEquals("John", argument.getValue());
  }

}