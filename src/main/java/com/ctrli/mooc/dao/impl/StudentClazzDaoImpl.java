package com.ctrli.mooc.dao.impl;

import com.ctrli.mooc.dao.StudentClazzDao;
import com.ctrli.mooc.entity.StudentClassEntity;
import com.ctrli.mooc.entity.StudentClassEntityPK;
import org.springframework.stereotype.Repository;

@Repository
public class StudentClazzDaoImpl extends BaseDaoImpl<StudentClassEntityPK, StudentClassEntity> implements StudentClazzDao {
}
