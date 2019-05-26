package com.ctrli.mooc.dao;

import com.ctrli.mooc.entity.AnalysisEntity;
import com.ctrli.mooc.entity.AnalysisEntityPK;
import com.ctrli.mooc.entity.ClazzEntity;

import java.util.List;

public interface AnalysisDao extends BaseDao<AnalysisEntityPK, AnalysisEntity>{
    /**
     *
     * @param cid
     * @param curPage
     * @param minScore
     * @return
     */
    public List<AnalysisEntity> countStudentPerPage(int cid, int curPage) throws Exception;
}
