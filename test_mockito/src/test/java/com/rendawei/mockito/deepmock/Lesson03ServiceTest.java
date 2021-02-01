package com.rendawei.mockito.deepmock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class Lesson03ServiceTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private Lesson03Service lesson03Service;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDeepMock(){
        lesson03Service.get().foo();
    }

}