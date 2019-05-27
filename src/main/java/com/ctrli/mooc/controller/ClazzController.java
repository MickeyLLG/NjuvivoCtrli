package com.ctrli.mooc.controller;

import com.ctrli.mooc.dto.Envelope;
import com.ctrli.mooc.entity.StudentEntity;
import com.ctrli.mooc.entity.TeacherEntity;
import com.ctrli.mooc.service.AnalysisService;
import com.ctrli.mooc.service.ClazzService;
import com.ctrli.mooc.service.StudentClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * Create by zekdot on 19-5-26.
 */

@RequestMapping("/class")
@Controller
@CrossOrigin
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private StudentClazzService studentClazzService;
    @Autowired
    private AnalysisService analysisService;

    /**
     * 利用上传课件方式开启一个新的课程
     * @param title 课程主题
     * @param file 二进制文件
     * @param session
     * @return 结果
     */
    @RequestMapping(value = "/uploadAndStart",method = RequestMethod.POST)
    @ResponseBody
    public String uploadAndStart(String title, MultipartFile file, HttpSession session){
        // 获取保存的用户对象
        Object user = session.getAttribute("user");
        // 如果为空或者不是教师实体
        if(user == null || !(user instanceof TeacherEntity)){
            return new Envelope(1,"只有教师可以上传课件并开始课程",null).toString();
        }
        // 转换用户为教师实体
        TeacherEntity teacherEntity = (TeacherEntity) user;
        try{
            // 调用service层方法开启一个新课程
            return clazzService.startNewService(title,teacherEntity.getTid(),file).toString();
        }catch (Exception e){
            e.printStackTrace();
            return Envelope.systemError.toString();
        }
    }

    /**
     * 获取教师历史保存的课件
     * @param session
     * @return 课件列表
     */
    @RequestMapping("/getHisClass")
    @ResponseBody
    public String getHisClass(HttpSession session){
        // 获取保存的用户对象
        Object user = session.getAttribute("user");
        //System.out.println("用户是"+user);
        // 如果为空或者不是教师实体
        if(user == null || !(user instanceof TeacherEntity)){
            return new Envelope(1,"只有教师可以获取历史上传课件列表",null).toString();
        }
        // 转换用户为教师实体
        TeacherEntity teacherEntity = (TeacherEntity) user;
        try{
            return clazzService.getHisPPTByTid(teacherEntity.getTid()).toString();
        }catch (Exception e){
            e.printStackTrace();
            return Envelope.systemError.toString();
        }
    }

    /**
     * 根据历史课程id开启一个课程
     * @param cid 历史课程id
     * @param session
     * @return 结果
     */
    @RequestMapping(value = "/startByHisCid",method = RequestMethod.POST)
    @ResponseBody
    public String startByHisCid(int cid,HttpSession session){
        // 获取保存的用户对象
        Object user = session.getAttribute("user");
        // 如果为空或者不是教师实体
        if(user == null || !(user instanceof TeacherEntity)){
            return new Envelope(1,"只有教师可以获取历史上传课件列表",null).toString();
        }
        // 转换用户为教师实体
        TeacherEntity teacherEntity = (TeacherEntity) user;
        try{
            return clazzService.startByHisCid(cid,teacherEntity.getTid()).toString();
        }catch (Exception e){
            e.printStackTrace();
            return Envelope.systemError.toString();
        }
    }

    /**
     * 根据课程id获取当前的页码
     * @param cid 课程id
     * @return 当前页码
     */
    @RequestMapping("/getCurPage")
    @ResponseBody
    public String getCurPage(int cid){
        try{
            return clazzService.getPPTPage(cid).toString();
        }catch (Exception e){
            e.printStackTrace();
            return Envelope.systemError.toString();
        }
    }

    /**
     * 修改页数
     * @param cid 课程号
     * @param newPageNum 新页码
     * @param session
     * @return 修改结果
     */
    @RequestMapping(value = "/updateCurPage",method = RequestMethod.POST)
    @ResponseBody
    public String updateCurPage(int cid,int newPageNum,HttpSession session){
        // 获取保存的用户对象
        Object user = session.getAttribute("user");
        // 如果为空或者不是教师实体
        if(user == null || !(user instanceof TeacherEntity)){
            return new Envelope(1,"只有教师可以翻动页面",null).toString();
        }
        // 转换用户为教师实体
        TeacherEntity teacherEntity = (TeacherEntity) user;
        try{
            return clazzService.updatePPTPage(cid,teacherEntity.getTid(),newPageNum).toString();
        }catch (Exception e){
            e.printStackTrace();
            return Envelope.systemError.toString();
        }
    }

    /**
     * 学生加入班级
     * @param cid 课程id
     * @param session
     * @return
     */
    @RequestMapping(value = "/studentGetIntoClazz",method = RequestMethod.POST)
    @ResponseBody
    public String studentGetIntoClazz(int cid,HttpSession session){
        // 获取保存的用户对象
        Object user = session.getAttribute("user");
        // 如果为空或者不是学生实体
        if(user == null || !(user instanceof StudentEntity)){
            return new Envelope(1,"只有学生可以加入课程",null).toString();
        }
        // 转换用户为教师实体
        StudentEntity studentEntity = (StudentEntity) user;
        try{
            // 调用service 层的加入方法
            return studentClazzService.studentGetIntoClazz(studentEntity.getSid(),cid).toString();
        }catch (Exception e){
            e.printStackTrace();
            return Envelope.systemError.toString();
        }
    }

    /**
     * 收集学生数据
     * @param cid 课程id
     * @param curPage 当前页面
     * @param data 数据
     * @param session
     * @return
     */
    @RequestMapping(value = "/colStuDat",method = RequestMethod.POST)
    @ResponseBody
    public String collectStudentData(int cid,int curPage,String data,HttpSession session){
        // 获取保存的用户对象
        Object user = session.getAttribute("user");
        // 如果为空或者不是学生实体
        if(user == null || !(user instanceof StudentEntity)){
            return new Envelope(1,"仅需获取学生的数据",null).toString();
        }
        // 转换用户为教师实体
        StudentEntity studentEntity = (StudentEntity) user;
        try{
            return analysisService.updateAnalysis(studentEntity.getSid(),cid,curPage,data).toString();
        }catch (Exception e){
            e.printStackTrace();
            return Envelope.systemError.toString();
        }
    }

    /**
     * 获取当前上课状态统计数据
     * @param cid 课程id
     * @param curPage 当前页码
     * @param session
     * @return
     */
    @RequestMapping("/getCurStaDat")
    @ResponseBody
    public String getCurStaDat(int cid,int curPage,HttpSession session){
        // 获取保存的用户对象
        Object user = session.getAttribute("user");
        // 如果为空或者不是教师实体
        if(user == null || !(user instanceof TeacherEntity)){
            return new Envelope(1,"只有教师可以获取上课状态数据",null).toString();
        }
        // 转换用户为教师实体
        TeacherEntity teacherEntity = (TeacherEntity) user;
        try{
            return analysisService.getPageAnalysis(cid,curPage).toString();
        }catch (Exception e){
            e.printStackTrace();
            return Envelope.systemError.toString();
        }
    }

    /**
     * 根据课程id获取总页数
     * @param cid 课程id
     * @return 总页数
     */
    @RequestMapping("/getPageNum")
    @ResponseBody
    public String getPageNumByCid(int cid){
        try{
            return clazzService.getPageInfo(cid).toString();
        }catch (Exception e){
            e.printStackTrace();
            return Envelope.systemError.toString();
        }
    }
}
