package com.ctrli.mooc.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * Create by zekdot on 19-5-26.
 */
public class StudentClassEntityPK implements Serializable {
    private String cid;
    private String sid;

    @Column(name = "cid")
    @Id
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentClassEntityPK that = (StudentClassEntityPK) o;
        return Objects.equals(cid, that.cid) &&
                Objects.equals(sid, that.sid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, sid);
    }
}
