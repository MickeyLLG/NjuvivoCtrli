package com.ctrli.mooc.servicetest;

import com.ctrli.mooc.MoocApplication;
import com.ctrli.mooc.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertEquals;
/**
 * Create by zekdot on 19-5-26.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MoocApplication.class)
public class TestServiceTest{
    @Autowired
    private TestService testService;
    @Test
    public void testAdd(){
        //System.out.println(testService.add(1,2));
        ;
        assertEquals(3,testService.add(1,2));
        //estService.add(-1,2);

    }
}
