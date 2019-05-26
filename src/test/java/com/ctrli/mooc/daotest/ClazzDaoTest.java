package com.ctrli.mooc.daotest;

import com.ctrli.mooc.TmallApplicationTests;
import com.ctrli.mooc.dao.ClazzDao;
import com.ctrli.mooc.entity.ClazzEntity;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Create by zekdot on 19-5-26.
 */
public class ClazzDaoTest extends TmallApplicationTests {
    @Resource
    private ClazzDao clazzDao;
    @Test
    public void testInsert(){
        ClazzEntity clazzEntity = new ClazzEntity();
        clazzEntity.setDirname("null");
        clazzEntity.setTid("123456");
        clazzEntity.setTime(new java.sql.Date(new Date().getTime()));
        clazzEntity.setTitle("测试");
        clazzEntity.setCurPage(0);
        try {
            clazzDao.save(clazzEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testGet(){
        try {
            ClazzEntity clazzEntity = clazzDao.get(2);
            Assert.assertEquals("null",clazzEntity.getDirname());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
