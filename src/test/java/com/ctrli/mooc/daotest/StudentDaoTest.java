package com.ctrli.mooc.daotest;

import com.ctrli.mooc.TmallApplicationTests;
import com.ctrli.mooc.dao.StudentDao;
import com.ctrli.mooc.entity.StudentEntity;
import com.ctrli.mooc.utiltest.PasswordUtil;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

public class StudentDaoTest extends TmallApplicationTests {
    @Resource
    private StudentDao studentDao;
    @Test
    public void insertTest(){
        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setSid("s7");
        studentEntity.setPassword(PasswordUtil.getMd5("s7"));
        try {
            studentDao.save(studentEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTest(){
        StudentEntity studentEntity= null;
        try {
            studentEntity = studentDao.get("s5");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(studentEntity.getPassword(),"s5");
    }


}
