package com.rendawei.mockito.quickstart;

import com.rendawei.mockito.quickstart.Account;
import com.rendawei.mockito.quickstart.AccountDao;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.mock;

public class MockByRuleTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testMock(){
        AccountDao accountDao = mock(AccountDao.class);
        Account account = accountDao.findAccount("x", "y");
        System.out.println(account);
    }
}
