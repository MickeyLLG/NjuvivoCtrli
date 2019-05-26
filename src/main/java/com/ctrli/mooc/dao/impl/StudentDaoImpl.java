package com.ctrli.mooc.dao.impl;

import com.ctrli.mooc.dao.BaseDao;
import com.ctrli.mooc.dao.StudentDao;
import com.ctrli.mooc.entity.StudentEntity;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl extends BaseDaoImpl<String, StudentEntity> implements StudentDao {
}
