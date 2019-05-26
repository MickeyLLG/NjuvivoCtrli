package com.ctrli.mooc.daotest;

import com.ctrli.mooc.TmallApplicationTests;
import com.ctrli.mooc.dao.TestDao;
import com.ctrli.mooc.entity.TestEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Create by zekdot on 19-5-26.
 */
public class TestDaoTest extends TmallApplicationTests {
    @Resource
    private TestDao testDao;
    @Test
    public void insertTest(){
        TestEntity testEntity = new TestEntity();
        testEntity.setTest("测试");
        try {
            testDao.save(testEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getTest(){
        try {
            TestEntity testEntity = testDao.get(1);
            Assert.assertEquals(testEntity.getTest(),"测试");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
