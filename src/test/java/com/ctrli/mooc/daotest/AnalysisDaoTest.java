package com.ctrli.mooc.daotest;

import com.ctrli.mooc.TmallApplicationTests;
import com.ctrli.mooc.dao.AnalysisDao;
import com.ctrli.mooc.entity.AnalysisEntity;
import com.ctrli.mooc.entity.AnalysisEntityPK;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

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

    @Test
    public void countTest(){
        try {
            List<AnalysisEntity> l=analysisDao.getStudentPerPage(1,3);
            for (AnalysisEntity o:l)
                System.out.println(o.getData());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
