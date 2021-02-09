package com.rendawei.mockito.quickstart;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Matchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class AccountLoginControllerTest {


    private AccountDao accountDao;
    private HttpServletRequest request;
    private AccountLoginController accountLoginController;


    @Before
    public void setUp() {
        this.accountDao = Mockito.mock(AccountDao.class);
        this.request = Mockito.mock(HttpServletRequest.class);
        this.accountLoginController = new AccountLoginController(accountDao);
    }

    @Test
    public void testLoginSuccess() {
        Account account = new Account();
        Mockito.when(request.getParameter("username")).thenReturn("Alex");
        Mockito.when(request.getParameter("password")).thenReturn("123456");

        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenReturn(account);

        String result = accountLoginController.login(request);

        assertThat(result, equalTo("/index"));
    }

    @Test
    public void testLoginFailure() {
        Mockito.when(request.getParameter("username")).thenReturn("Alex");
        Mockito.when(request.getParameter("password")).thenReturn("1234561");

        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenReturn(null);

        String result = accountLoginController.login(request);

        assertThat(result, equalTo("/login"));
    }

    @Test
    public void testLogin505() {
        Mockito.when(request.getParameter("username")).thenReturn("Alex");
        Mockito.when(request.getParameter("password")).thenReturn("1234561");

        Mockito.when(accountDao.findAccount(anyString(), anyString())).thenThrow(UnsupportedOperationException.class);

        String result = accountLoginController.login(request);

        assertThat(result, equalTo("/505"));
    }
}