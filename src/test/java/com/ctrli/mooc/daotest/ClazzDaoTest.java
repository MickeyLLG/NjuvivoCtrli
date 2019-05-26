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
        clazzEntity.setFilename("null");
        clazzEntity.setTid("123456");
        clazzEntity.setTime(new java.sql.Date(new Date().getTime()));
        clazzEntity.setTitle("测试");
        try {
            clazzDao.save(clazzEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testGet(){
        try {
            ClazzEntity clazzEntity = clazzDao.get(1);
            Assert.assertEquals("null",clazzEntity.getFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
