package com.ctrli.mooc.service.impl;

import com.ctrli.mooc.dao.AnalysisDao;
import com.ctrli.mooc.dao.BaseDao;
import com.ctrli.mooc.dao.StudentClazzDao;
import com.ctrli.mooc.dto.Envelope;
import com.ctrli.mooc.entity.AnalysisEntity;
import com.ctrli.mooc.entity.StudentClassEntity;
import com.ctrli.mooc.entity.StudentClassEntityPK;
import com.ctrli.mooc.service.StudentClazzService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

@Service
public class StudentClazzServiceImpl implements StudentClazzService {
@Resource
private StudentClazzDao studentClazzDao;

    @Override
    public Envelope studentGetIntoClazz(String sid, int cid) {
        if (sid==null||sid.equals(""))
            return new Envelope(1,"学生id不能为空",null);
        if (cid<1)
            return new Envelope(2,"课程id不正确",null);
        StudentClassEntity studentClassEntity=new StudentClassEntity();
        studentClassEntity.setSid(sid);
        studentClassEntity.setCid(cid);
        java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
        studentClassEntity.setTime(date);
        try {
            studentClazzDao.save(studentClassEntity);
        } catch (org.hibernate.exception.ConstraintViolationException sqle) {
            //sqle.printStackTrace();
            return new Envelope(3,"不能重复进入该课程",null);
        }catch (Exception e){
            e.printStackTrace();
            return Envelope.dbError;
        }
        return Envelope.success;
    }


}
