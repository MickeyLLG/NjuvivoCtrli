package com.ctrli.mooc.service.impl;

import com.ctrli.mooc.dao.AnalysisDao;
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
        List<AnalysisEntity> analysisEntityList;
        int total,happyCount=0,sadCount=0;
        try {
            analysisEntityList=analysisDao.countStudentPerPage(cid,curPage);
        } catch (Exception e) {
            e.printStackTrace();
            return Envelope.dbError;
        }
        total=analysisEntityList.size();
        for (AnalysisEntity analysisEntity:analysisEntityList){
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
}
