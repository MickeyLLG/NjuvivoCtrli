package com.ctrli.mooc.service.impl;

import com.ctrli.mooc.dao.AnalysisDao;
import com.ctrli.mooc.dao.ClazzDao;
import com.ctrli.mooc.dto.Envelope;
import com.ctrli.mooc.entity.AnalysisEntity;
import com.ctrli.mooc.service.AnalysisService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnalysisServiceImpl implements AnalysisService {
    @Resource
    private AnalysisDao analysisDao;
    @Resource
    private ClazzDao clazzDao;
    @Override
    public Envelope updateAnalysis(String sid, int cid,int curPage,String data) {
        AnalysisEntity analysisEntity=new AnalysisEntity();
        analysisEntity.setCid(cid);
        analysisEntity.setSid(sid);
        analysisEntity.setCurPage(curPage);
        analysisEntity.setData(data);
        try {
            analysisDao.saveOrUpdate(analysisEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return Envelope.dbError;
        }
        return Envelope.success;
    }

    @Override
    public Envelope getPageAnalysis(int cid, int curPage) {
        List<AnalysisEntity> studentPerPageList;
        int total,happyCount=0,sadCount=0;
        try {
            studentPerPageList=analysisDao.getStudentPerPage(cid,curPage);
        } catch (Exception e) {
            e.printStackTrace();
            return Envelope.dbError;
        }
        if (studentPerPageList.size()<=0||studentPerPageList==null){
            JSONObject result=new JSONObject();
            result.put("happyCount",0);
            result.put("sadCount",0);

            return new Envelope(0,"success",result);
        }
            //return new Envelope(1,"没有找到该页",null);
        total=studentPerPageList.size();
        for (AnalysisEntity analysisEntity:studentPerPageList){
            JSONObject data=JSONObject.fromObject(analysisEntity.getData());
            double score=data.getDouble("score");
            happyCount+=score>=0?1:0;
        }
        sadCount=total-happyCount;
        JSONObject result=new JSONObject();
        result.put("happyCount",happyCount);
        result.put("sadCount",sadCount);

        return new Envelope(0,"success",result);
    }

    @Override
    public Envelope getClazzAnalysis(int cid) {
        List<AnalysisEntity> studentPerClazzList;
        int totalStudentNum,happyCount=0,sadCount=0;
        try {
            studentPerClazzList=analysisDao.getStudentPerClazz(cid);

        } catch (Exception e) {
            e.printStackTrace();
            return Envelope.dbError;
        }
        if (studentPerClazzList.size()<=0||studentPerClazzList==null)
            return new Envelope(1,"没有找到该课程",null);
        totalStudentNum=studentPerClazzList.size();
        for (AnalysisEntity analysisEntity:studentPerClazzList){
            JSONObject data=JSONObject.fromObject(analysisEntity.getData());
            double score=data.getDouble("score");
            happyCount+=score>=0?1:0;
        }
        sadCount=totalStudentNum-happyCount;
        JSONObject result=new JSONObject();
        result.put("happyCount",happyCount);
        result.put("sadCount",sadCount);

        return new Envelope(0,"success",result);
    }
}
