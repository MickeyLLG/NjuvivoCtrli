package com.ctrli.mooc.service;

import com.ctrli.mooc.dto.Envelope;

public interface AnalysisService {
    /**
     *
     * @param sid
     * @param cid
     * @param curPage
     * @param data
     * @return
     */
    public Envelope updateAnalysis(String sid, int cid, int curPage, String data);

    /**
     *
     * @param cid
     * @param curPage
     * @return
     */
    public Envelope getPageAnalysis(int cid,int curPage,double threshold);
}
