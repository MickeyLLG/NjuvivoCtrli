package com.ctrli.mooc.dao.impl;

import com.ctrli.mooc.dao.ClazzDao;
import com.ctrli.mooc.entity.ClazzEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

/**
 * Create by zekdot on 19-5-26.
 */
@Repository
public class ClazzDaoImpl extends BaseDaoImpl<Integer, ClazzEntity> implements ClazzDao {
    @Override
    public List<ClazzEntity> getClazzListBytid(String tid) throws Exception {
        String hql = "from ClazzEntity where tid = ?";
        Object param[] = {tid};
        return executeHQL(hql,param);
    }
}
