package com.ctrli.mooc.util;

import com.ctrli.mooc.TmallApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Create by zekdot on 19-5-26.
 */
public class FileUtilTest extends TmallApplicationTests {

    @Test
    public void testOpen(){
        MultipartFile mf = FileUtil.getFile("/home/zekdot/桌面/区块链/第五章 区块链架构 - 2 以太坊.pptx");
        System.out.println();
        FileUtil.saveFile(mf,"test.pptx","/home/zekdot/桌面/区块链/");
    }
}
