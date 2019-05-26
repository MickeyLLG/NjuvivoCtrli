package com.ctrli.mooc.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Create by zekdot on 19-5-26.
 */
public class AnalysisEntityPK implements Serializable {
    private int cid;
    private String sid;
    private int curPage;

    @Column(name = "cid")
    @Id
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Column(name = "sid")
    @Id
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Column(name = "cur_page")
    @Id
    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnalysisEntityPK that = (AnalysisEntityPK) o;
        return cid == that.cid &&
                curPage == that.curPage &&
                Objects.equals(sid, that.sid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, sid, curPage);
    }
}
