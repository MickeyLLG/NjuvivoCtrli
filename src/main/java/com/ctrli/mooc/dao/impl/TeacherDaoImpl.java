package com.ctrli.mooc.dao.impl;

import com.ctrli.mooc.dao.TeacherDao;
import com.ctrli.mooc.entity.TeacherEntity;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDaoImpl extends BaseDaoImpl<String, TeacherEntity> implements TeacherDao {
}
