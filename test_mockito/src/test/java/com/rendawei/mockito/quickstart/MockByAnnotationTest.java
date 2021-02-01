package com.rendawei.mockito.quickstart;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MockByAnnotationTest {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    private AccountDao accountDao;

    @Test
    public void testMock(){
        // 得到的返回值为@Mock(answer = Answers.RETURNS_SMART_NULLS)中设置的值
        Account account = accountDao.findAccount("x","y");
        System.out.println(account);
    }
}
