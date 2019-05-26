package com.ctrli.mooc.service;

import com.ctrli.mooc.dto.Envelope;
import org.springframework.web.multipart.MultipartFile;

/**
 * Create by zekdot on 19-5-26.
 */
public interface ClazzService {
    /**
     * 开启一个新课
     * @param title 课程主题
     * @param tId 教师id
     * @param file PPT文件
     * @return 包含新课id的课程
     */
    public Envelope startNewService(String title, String tId, MultipartFile file);

    /**
     * 修改当前的PPT页数
     * @param cid 课程id
     * @param tid 教师id
     * @param newPageNum 新的页码
     * @return 是否成功
     */
    public Envelope updatePPTPage(int cid,String tid,int newPageNum);

    /**
     * 获取当前的PPT的页数
     * @param cid 课程id
     * @return 当前页码
     */
    public Envelope getPPTPage(int cid);

    /**
     * 根据教师id获取历史上传的PPT-主题列表
     * @param tid 教师id
     * @return 列表信息
     */
    public Envelope getHisPPTByTid(String tid);

}
