package com.ctrli.mooc.dao.impl;

import com.ctrli.mooc.dao.TestDao;
import com.ctrli.mooc.entity.TestEntity;
import org.springframework.stereotype.Repository;

/**
 * Create by zekdot on 19-5-26.
 */
@Repository
public class TestDaoImpl  extends BaseDaoImpl<Integer, TestEntity> implements TestDao {
}
