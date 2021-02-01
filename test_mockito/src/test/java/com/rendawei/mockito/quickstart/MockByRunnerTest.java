package com.rendawei.mockito.quickstart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MockByRunnerTest {

    @Test
    public void testMock(){
        AccountDao accountDao = mock(AccountDao.class);
        Account account = accountDao.findAccount("x", "y");  // 此时执行并不会报错，但是返回的是null
        System.out.println(account);

        AccountDao accountDao1 = mock(AccountDao.class, Mockito.RETURNS_SMART_NULLS);
        Account account1 = accountDao1.findAccount("x", "y");  // 此时执行并不会报错，但是返回的是字符串类型的方法
        System.out.println(account1);
    }
}
