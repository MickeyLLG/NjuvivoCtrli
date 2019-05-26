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
    public Envelope updatePPTPage(int cid,int tid,int newPageNum);

    /**
     * 获取当前的PPT的页数
     * @param cid 课程id
     * @param sid 学生id
     * @return 当前页码
     */
    public Envelope getPPTPage(int cid,int sid);


}
