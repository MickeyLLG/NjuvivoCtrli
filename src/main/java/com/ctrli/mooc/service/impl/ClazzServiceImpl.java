package com.ctrli.mooc.service.impl;

import com.ctrli.mooc.GlobalConfig;
import com.ctrli.mooc.dao.ClazzDao;
import com.ctrli.mooc.dto.Envelope;
import com.ctrli.mooc.entity.ClazzEntity;
import com.ctrli.mooc.service.ClazzService;
import com.ctrli.mooc.utiltest.FileUtil;
import com.ctrli.mooc.utiltest.PPTToPicUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * Create by zekdot on 19-5-26.
 */
@Service
public class ClazzServiceImpl implements ClazzService {
    @Resource
    private ClazzDao clazzDao;
    @Override
    public Envelope startNewService(String title, String tId, MultipartFile file) {
        // 检查主题输入合法性
        if(title == null){
            return new Envelope(1,"主题不能为空",null);
        }
        if(title.length() > 20){
            return new Envelope(2,"主题过长",null);
        }
        // 检查文件是否为空
        if(file == null){
            return new Envelope(3,"文件不可为空！",null);
        }
        // 在数据库中新增加一个记录，并获取主键
        ClazzEntity clazzEntity = new ClazzEntity();
        // 设置主题
        clazzEntity.setTitle(title);
        // 设置教师id
        clazzEntity.setTid(tId);
        // 设置时间
        clazzEntity.setTime(new Date(new java.util.Date().getTime()));
        // 设置当前页数为0 表示还没开始上课
        clazzEntity.setCurPage(0);
        // 保存课程信息
        try {
            // 保存班级实体
            clazzDao.save(clazzEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return Envelope.dbError;
        }
        // 主键作为文件名在/home/zekdot/njuvivo下新建文件夹，将PPT文件输入到文件夹中
        // 构建文件夹名称
        String folderName = new StringBuilder().append(GlobalConfig.PPT_FOLDER).append(clazzEntity.getCid()).append("/").toString();
        // 构建文件夹对象
        File folder = new File(folderName);
        // 创建文件夹
        if(!folder.mkdir()){
            // 如果失败，返回原因
            return new Envelope(-3,"文件夹创建错误",null);
        }
        // 存储PPT
        if (FileUtil.saveFile(file, "slider.pptx",folderName)) {
            //成功存储文件
            ;
        } else {
            // 存储文件失败
            return new Envelope(-4, "文件存储失败", null);
        }
        // 将文件夹中的PPT转换为图片，并且存储在文件夹中，同时获取PPT页数
        int pptNum = PPTToPicUtil.savePPTtoImage(folderName+"slider.pptx",folderName);
        // 更新数据库中id对应的主键字段
        // 设置字段
        clazzEntity.setDirname(folderName);
        // 设置总页数
        clazzEntity.setPageNum(pptNum);
        // 更新
        try {
            clazzDao.update(clazzEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return Envelope.dbError;
        }
        // 用于返回的对象
        JSONObject jsonObject = new JSONObject();
        // 设置页码
        jsonObject.put("pageNum",pptNum);
        // 设置课程暗号
        jsonObject.put("cid",clazzEntity.getCid());
        // 返回成功后的信息
        return new Envelope(jsonObject);
    }

    @Override
    public Envelope updatePPTPage(int cid, String tid, int newPageNum) {
        // 新建班级实体
        ClazzEntity clazzEntity;
        try {
            // 读取数据库中的班级实体
            clazzEntity = clazzDao.get(cid);
        } catch (Exception e) {
            e.printStackTrace();
            return Envelope.dbError;
        }
        // 如果课程不存在
        if(clazzEntity == null){
            // 返回失败信息
            return new Envelope(1,"该课程不存在",null);
        }
        // 如果非本人
        if(!clazzEntity.getTid().equals(tid)){
            // 返回失败信息
            return new Envelope(2,"您不能翻动别人的PPT",null);
        }
        if(newPageNum > clazzEntity.getPageNum()){
            return new Envelope(3,"已经到达末尾了",null);
        }
        // 设置新的页码
        clazzEntity.setCurPage(newPageNum);

        // 更新数据库
        try {
            clazzDao.update(clazzEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回成功信息
        return new Envelope(newPageNum);
    }

    @Override
    public Envelope getPPTPage(int cid) {
        // 新建班级实体
        ClazzEntity clazzEntity;
        try {
            // 读取数据库中的班级实体
            clazzEntity = clazzDao.get(cid);
        } catch (Exception e) {
            e.printStackTrace();
            return Envelope.dbError;
        }
        // 如果课程不存在
        if(clazzEntity == null){
            // 返回失败信息
            return new Envelope(1,"该课程不存在",null);
        }
        // 返回当前的页面
        return new Envelope(clazzEntity.getCurPage());
    }

    @Override
    public Envelope getHisPPTByTid(String tid) {
        Map<String,Boolean> isUsed = new HashedMap();
        List<ClazzEntity> list = null;
        try {
            // 根据教师id获取所有课程
            list = clazzDao.getClazzListBytid(tid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 保存主题、文件路径列表
        JSONArray jsonArray = new JSONArray();
        // 保存某一个主题、文件
        JSONObject jsonObject;
        // 遍历每一个课程
        for(ClazzEntity clazzEntity:list){
            // 如果标题出现过
            if(isUsed.get(clazzEntity.getTitle())!=null&&isUsed.get(clazzEntity.getTitle()))
                continue;
            jsonObject = new JSONObject();
            // 设置课程id
            jsonObject.put("cid",clazzEntity.getCid());
            // 设置标题
            jsonObject.put("title",clazzEntity.getTitle());
            // 设置标题出现过
            isUsed.put(clazzEntity.getTitle(),true);
            jsonArray.add(jsonObject);
        }
        // 返回列表
        return new Envelope(jsonArray);
    }

    @Override
    public Envelope startByHisCid(int cid, String tid) {
        ClazzEntity hisEntity = null;
        try {
            // 读取历史课程实体
            hisEntity = clazzDao.get(cid);
        } catch (Exception e) {
            e.printStackTrace();
            return Envelope.dbError;
        }
        // 如果历史课程为空
        if(hisEntity == null){
            return new Envelope(1,"您填写的历史课程不存在",null);
        }
        // 如果不是本人的历史课程
        if(!hisEntity.getTid().equals(tid)){
            return new Envelope(2,"您不能使用他人的历史课程",null);
        }
        // 新建一个课程实体
        ClazzEntity clazzEntity = new ClazzEntity();
        // 利用历史课程id构造一个文件夹名
        String folderName = new StringBuilder().append(GlobalConfig.PPT_FOLDER).append(cid).append("/").toString();
        // 设置文件夹URL
        clazzEntity.setDirname(folderName);
        // 设置时间
        clazzEntity.setTime(new Date(new java.util.Date().getTime()));
        // 设置教师id
        clazzEntity.setTid(tid);
        // 设置当前page
        clazzEntity.setCurPage(0);
        // 设置当前主题
        clazzEntity.setTitle(hisEntity.getTitle());
        // 设置总页数
        clazzEntity.setPageNum(hisEntity.getPageNum());
        try {
            // 实际存储操作
            clazzDao.saveAndFlush(clazzEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return Envelope.dbError;
        }
        JSONObject jsonObject = new JSONObject();
        // 放置总页数
        jsonObject.put("pageNum",hisEntity.getPageNum());
        // 放置课程id
        jsonObject.put("cid",clazzEntity.getCid());
        // 返回
        return new Envelope(jsonObject);
    }

    @Override
    public Envelope getPageInfo(int cid) {
        ClazzEntity clazzEntity;
        try {
            clazzEntity = clazzDao.get(cid);
        } catch (Exception e) {
            e.printStackTrace();
            return Envelope.dbError;
        }
        if(clazzEntity == null){
            return new Envelope(1,"没有找到该课程",null);
        }

        // 返回pageNum,dirname
        JSONObject result=new JSONObject();
        result.put("pageNum",clazzEntity.getPageNum());
        result.put("dirname",clazzEntity.getDirname().split("njuvivo/")[1]);
        return new Envelope(0,"success",result);
    }


}
