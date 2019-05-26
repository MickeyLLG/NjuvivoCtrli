package com.ctrli.mooc.servicetest;

import com.ctrli.mooc.TmallApplicationTests;
import com.ctrli.mooc.service.LoginService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class LoginServiceImplTest extends TmallApplicationTests {
    @Autowired
    private LoginService loginService;
    @Test
    public void loginTest() {
        int code=loginService.login("s7","s7","student").getCode();
        Assert.assertEquals(0,code);
        code=loginService.login(null,"s7","student").getCode();
        Assert.assertEquals(1,code);
        code=loginService.login("s7","","student").getCode();
        Assert.assertEquals(2,code);
        code=loginService.login("s7","s7","1").getCode();
        Assert.assertEquals(3,code);
        code=loginService.login("s8","s8","student").getCode();
        Assert.assertEquals(4,code);
        code=loginService.login("s7","s8","student").getCode();
        Assert.assertEquals(5,code);
    }
}