package com.rendawei.mockito.realcall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StubbingServiceTest {

    @Test
    public void stubbingWithRealCall(){
        /*
        * 当使用mock一个类的时候，他会创建这个类的替身，也就是说是假的类，当然方法也不会执行本身的方法，只会虚拟一个方法的结果，但是如果就是想执行
        * 本身的方法的话，就使用thenCallRealMethod
        *
        * */
        StubbingService service = mock(StubbingService.class);
        Mockito.when(service.getS()).thenReturn("Alex");
        assertThat(service.getS(), equalTo("Alex"));

        when(service.getI()).thenCallRealMethod();
        assertThat(service.getI(), equalTo(10));
    }

}