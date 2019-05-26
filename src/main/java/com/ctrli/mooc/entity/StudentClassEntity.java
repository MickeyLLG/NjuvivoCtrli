package com.ctrli.mooc.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * Create by zekdot on 19-5-26.
 */
@Entity
@Table(name = "student_class", schema = "nju_vivo", catalog = "")
@IdClass(StudentClassEntityPK.class)
public class StudentClassEntity {
    private String cid;
    private String sid;
    private Date time;
    private String analysis;

    @Id
    @Column(name = "cid")
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Id
    @Column(name = "sid")
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name = "analysis")
    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentClassEntity that = (StudentClassEntity) o;
        return Objects.equals(cid, that.cid) &&
                Objects.equals(sid, that.sid) &&
                Objects.equals(time, that.time) &&
                Objects.equals(analysis, that.analysis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, sid, time, analysis);
    }
}
