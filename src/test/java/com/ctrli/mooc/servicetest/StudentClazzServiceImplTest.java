package com.ctrli.mooc.servicetest;

import com.ctrli.mooc.TmallApplicationTests;
import com.ctrli.mooc.dto.Envelope;
import com.ctrli.mooc.service.StudentClazzService;
import com.ctrli.mooc.service.impl.StudentClazzServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class StudentClazzServiceImplTest extends TmallApplicationTests {
    @Autowired
    private StudentClazzService studentClazzService;

    @Test
    public void studentGetIntoClazzTest() {
        int code;

        code=studentClazzService.studentGetIntoClazz("",1).getCode();
        Assert.assertEquals(1,code);
        code=studentClazzService.studentGetIntoClazz("s2",-1).getCode();
        Assert.assertEquals(2,code);
        code=studentClazzService.studentGetIntoClazz("s1",1).getCode();
        Assert.assertEquals(0,code);
        code=studentClazzService.studentGetIntoClazz("s1",1).getCode();
        Assert.assertEquals(3,code);

    }

    @Test
    public void clazzOffTest() {
    }
}