package com.ctrli.mooc.daotest;

import com.ctrli.mooc.TmallApplicationTests;
import com.ctrli.mooc.dao.ClazzDao;
import com.ctrli.mooc.dao.StudentClazzDao;
import com.ctrli.mooc.entity.StudentClassEntity;
import com.ctrli.mooc.entity.StudentClassEntityPK;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

public class StudentClazzTest extends TmallApplicationTests {
    @Resource
    private StudentClazzDao studentClazzDao;

    @Test
    public void insertTest(){
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        StudentClassEntity studentClassEntity=new StudentClassEntity();
        studentClassEntity.setSid("s1");
        studentClassEntity.setCid("c1");
        studentClassEntity.setTime(date);
        //studentClassEntity.setAnalysis("kldlhm");
        try {
            studentClazzDao.save(studentClassEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTest(){
        StudentClassEntityPK scpk=new StudentClassEntityPK();
        scpk.setCid("s1");
        scpk.setSid("c1");
        try {
            StudentClassEntity sce=studentClazzDao.get(scpk);
            //Assert.assertEquals("kldlhm",sce.getAnalysis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
