package com.ctrli.mooc.servicetest;

import com.ctrli.mooc.TmallApplicationTests;
import com.ctrli.mooc.service.ClazzService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Create by zekdot on 19-5-26.
 */
public class ClazzServiceTest extends TmallApplicationTests {
    @Autowired
    private ClazzService clazzService;
    @Test
    public void testStartNewClass(){
        Assert.assertEquals(clazzService.startNewService(null,"12",null).getCode(),1);
        Assert.assertEquals(clazzService.startNewService("ddddddddddddddddasfdasfsdfddddddddddd","12",null).getCode(),2);
        Assert.assertEquals(clazzService.startNewService("test","123",null).getCode(),3);
    }
}
