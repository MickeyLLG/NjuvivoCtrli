package com.ctrli.mooc.servicetest;

import com.ctrli.mooc.TmallApplicationTests;
import com.ctrli.mooc.dto.Envelope;
import com.ctrli.mooc.service.ClazzService;
import com.ctrli.mooc.utiltest.FileUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/**
 * Create by zekdot on 19-5-26.
 */
public class ClazzServiceTest extends TmallApplicationTests {
    @Autowired
    private ClazzService clazzService;
    @Test
    public void testFailedStartNewClass(){
        Assert.assertEquals(clazzService.startNewService(null,"12",null).getCode(),1);
        Assert.assertEquals(clazzService.startNewService("ddddddddddddddddasfdasfsdfddddddddddd","12",null).getCode(),2);
        Assert.assertEquals(clazzService.startNewService("test","123",null).getCode(),3);
    }

    @Test
    public void testSuccessNewClass(){
        MultipartFile mf = FileUtil.getFile("/home/zekdot/桌面/区块链/第五章 区块链架构 - 2 以太坊.pptx");
        Envelope envelope = clazzService.startNewService("测试","123",mf);
        Assert.assertEquals(envelope.getCode(),0);
        JSONObject jsonObject = JSONObject.fromObject(envelope.getObj());
        Assert.assertEquals(jsonObject.getInt("pageNum"),45);
        //Assert.assertEquals(jsonObject.getInt("cid"),6);
        System.out.println(jsonObject.toString());
    }

    @Test
    public void testUpdatePage(){
        Assert.assertEquals(clazzService.updatePPTPage(7,"456",10).getCode(),1);
        Assert.assertEquals(clazzService.updatePPTPage(6,"545",10).getCode(),2);
        Assert.assertEquals(clazzService.updatePPTPage(6,"123",10).getCode(),0);
    }
    @Test
    public void testGetPage(){
        Assert.assertEquals(clazzService.getPPTPage(7).getCode(),1);
        Assert.assertEquals(clazzService.getPPTPage(6).getObj(),10);
    }

    @Test
    public void testGetPageList(){
        JSONArray jsonArray = JSONArray.fromObject(clazzService.getHisPPTByTid("444").getObj());

        Assert.assertEquals(jsonArray.size(),0);
        jsonArray = JSONArray.fromObject(clazzService.getHisPPTByTid("123").getObj());
        System.out.println(jsonArray);
        Assert.assertEquals(jsonArray.size(),5);
    }

    @Test
    public void testStartByHisCid(){
        Assert.assertEquals(1,clazzService.startByHisCid(100,"test").getCode());
        Assert.assertEquals(2,clazzService.startByHisCid(7,"test").getCode());
        Assert.assertEquals(0,clazzService.startByHisCid(7,"123").getCode());
        System.out.println(clazzService.startByHisCid(7,"123"));
    }
}
