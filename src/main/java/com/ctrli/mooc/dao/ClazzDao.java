package com.ctrli.mooc.dao;

import com.ctrli.mooc.entity.ClazzEntity;

import java.util.List;

/**
 * Create by zekdot on 19-5-26.
 */
public interface ClazzDao extends BaseDao<Integer, ClazzEntity> {
    /**
     * 根据教师id获取班级
     * @param tid
     * @return
     */
    public List<ClazzEntity> getClazzListBytid(String tid) throws Exception;
}
