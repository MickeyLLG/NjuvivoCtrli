package com.ctrli.mooc.service;

import com.ctrli.mooc.dto.Envelope;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;

public interface AnalysisService {
    /**
     *
     * @param sid 学生id
     * @param cid 课程id
     * @param curPage 当前页码
     * @param data 数据
     * @return
     */
    public Envelope updateAnalysis(String sid, int cid, int curPage, String data);

    /**
     *
     * @param cid
     * @param curPage
     * @return
     */
    public Envelope getPageAnalysis(int cid,int curPage);

    /**
     * \
     * @param cid
     * @return
     */
    public Envelope getClazzAnalysis(int cid);
}
