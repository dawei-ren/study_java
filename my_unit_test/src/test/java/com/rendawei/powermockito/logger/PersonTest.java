package com.rendawei.powermockito.logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(PowerMockRunner.class)
@PrepareForTest({LoggerFactory.class})
public class PersonTest {

  @Test
  public void testLogger(){
    PowerMockito.mockStatic(LoggerFactory.class);
    Logger loggerMock = PowerMockito.mock(Logger.class);
    PowerMockito.when(LoggerFactory.getLogger(Mockito.any(Class.class))).thenReturn(loggerMock);

    Person person = new Person("Tom", -1);
    person.sayHi();

    Mockito.verify(loggerMock, Mockito.times(1)).error("age error");
  }



}