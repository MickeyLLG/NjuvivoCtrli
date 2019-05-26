package com.ctrli.mooc.servicetest;

import com.ctrli.mooc.TmallApplicationTests;
import com.ctrli.mooc.dto.Envelope;
import com.ctrli.mooc.service.ClazzService;
import com.ctrli.mooc.util.FileUtil;
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
        Assert.assertEquals(jsonObject.getInt("cid"),6);

    }
}
