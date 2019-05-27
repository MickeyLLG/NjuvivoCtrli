package com.ctrli.mooc.dao.impl;

import com.ctrli.mooc.dao.AnalysisDao;
import com.ctrli.mooc.dao.ClazzDao;
import com.ctrli.mooc.entity.AnalysisEntity;
import com.ctrli.mooc.entity.AnalysisEntityPK;
import com.ctrli.mooc.entity.ClazzEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnalysisDaoImpl extends BaseDaoImpl<AnalysisEntityPK, AnalysisEntity> implements AnalysisDao {
    @Override
    public List<AnalysisEntity> getStudentPerPage(int cid, int curPage) throws Exception {
        String hql="from AnalysisEntity where cid=? and curPage=?";
        Object[] params={cid,curPage};

        return executeHQL(hql,params);
    }

    @Override
    public List<AnalysisEntity> getStudentPerClazz(int cid) throws Exception {
        String hql="from AnalysisEntity where cid=?";
        Object[] params={cid};
        return executeHQL(hql,params);
    }
}
