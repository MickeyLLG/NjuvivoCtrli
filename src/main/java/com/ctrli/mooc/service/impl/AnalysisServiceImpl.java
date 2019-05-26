package com.ctrli.mooc.service.impl;

import com.ctrli.mooc.dao.AnalysisDao;
import com.ctrli.mooc.dto.Envelope;
import com.ctrli.mooc.entity.AnalysisEntity;
import com.ctrli.mooc.service.AnalysisService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
            analysisDao.save(analysisEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return Envelope.dbError;
        }
        return Envelope.success;
    }
}
