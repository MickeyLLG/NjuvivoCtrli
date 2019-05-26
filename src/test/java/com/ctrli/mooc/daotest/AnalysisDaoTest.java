package com.ctrli.mooc.daotest;

import com.ctrli.mooc.TmallApplicationTests;
import com.ctrli.mooc.dao.AnalysisDao;
import com.ctrli.mooc.dao.ClazzDao;
import com.ctrli.mooc.entity.AnalysisEntity;
import com.ctrli.mooc.entity.AnalysisEntityPK;
import org.junit.Test;

import javax.annotation.Resource;

public class AnalysisDaoTest extends TmallApplicationTests {
    @Resource
    private AnalysisDao analysisDao;

    @Test
    public void insertTest(){
        AnalysisEntityPK analysisEntityPK=new AnalysisEntityPK();
        //analysisEntityPK.setCid("c1");
        analysisEntityPK.setSid("s1");
        AnalysisEntity analysisEntity=new AnalysisEntity();
        analysisEntity.setCurPage(1);
        analysisEntity.setSid("s1");
        //analysisEntity.setCid();
    }
}
