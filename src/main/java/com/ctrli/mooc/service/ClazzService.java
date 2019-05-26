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


}
