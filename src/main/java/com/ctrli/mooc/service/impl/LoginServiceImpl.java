package com.ctrli.mooc.service.impl;

import com.ctrli.mooc.dao.StudentDao;
import com.ctrli.mooc.dao.TeacherDao;
import com.ctrli.mooc.dto.Envelope;
import com.ctrli.mooc.entity.StudentEntity;
import com.ctrli.mooc.entity.TeacherEntity;
import com.ctrli.mooc.service.LoginService;
import com.ctrli.mooc.utiltest.PasswordUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private StudentDao studentDao;
    @Resource
    private TeacherDao teacherDao;
    @Override
    public Envelope login(String username, String password, String type) {
        if (username==null||username.equals(""))
            return new Envelope(1,"用户名不能为空",null);
        if (password==null||password.equals(""))
            return new Envelope(2,"密码不能为空",null);
        if (type == null || (!type.equals("teacher")&&!type.equals("student")))
            return new Envelope(3,"用户类型错误",null);
        password=PasswordUtil.getMd5(password);
        String pwd=null;
        StudentEntity studentEntity = null;
        TeacherEntity teacherEntity = null;
        try {
            if (type.equals("student")){
                studentEntity=studentDao.get(username);
                if (studentEntity==null)
                    return new Envelope(4,"用户名不存在",null);
                else
                    pwd=studentEntity.getPassword();
            }
            else {
                teacherEntity = teacherDao.get(username);
                if (teacherEntity == null)
                    return new Envelope(4, "用户名不存在", null);
                else pwd = teacherEntity.getPassword();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Envelope.dbError;
        }
        if (!pwd.equals(password))
            return new Envelope(5,"用户名或密码错误",null);
        return new Envelope(teacherEntity == null?studentEntity:teacherEntity);
    }
}
