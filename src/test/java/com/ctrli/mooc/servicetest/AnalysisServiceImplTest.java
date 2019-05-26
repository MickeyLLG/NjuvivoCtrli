package com.ctrli.mooc.servicetest;

import com.ctrli.mooc.TmallApplicationTests;
import com.ctrli.mooc.service.AnalysisService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class AnalysisServiceImplTest extends TmallApplicationTests {
    @Autowired
    private AnalysisService analysisService;

    @Test
    public void updateAnalysisTest() {
        String data="{\n" +
                "\"score\":5,\n" +
                "\"anger\":14.67,\n" +
                "\"fear\":0.163,\n" +
                "\"happiness\":1.936,\n" +
                "\"neutral\":68.429,\n" +
                "\"sadness\":14.67,\n" +
                "\"surprise\":11.633\n" +
                "}";
        int code=analysisService.updateAnalysis("s1",1,3,data).getCode();
        Assert.assertEquals(0,code);
    }
}