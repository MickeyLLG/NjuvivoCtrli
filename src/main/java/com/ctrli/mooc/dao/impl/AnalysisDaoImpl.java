package com.ctrli.mooc.dao.impl;

import com.ctrli.mooc.dao.AnalysisDao;
import com.ctrli.mooc.dao.ClazzDao;
import com.ctrli.mooc.entity.AnalysisEntity;
import com.ctrli.mooc.entity.AnalysisEntityPK;
import com.ctrli.mooc.entity.ClazzEntity;
import org.springframework.stereotype.Repository;

@Repository
public class AnalysisDaoImpl extends BaseDaoImpl<AnalysisEntityPK, AnalysisEntity> implements AnalysisDao {
}
