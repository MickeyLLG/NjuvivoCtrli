package com.ctrli.mooc.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * Create by zekdot on 19-5-26.
 */
@Entity
@Table(name = "class", schema = "nju_vivo", catalog = "")
public class ClazzEntity {
    private Integer cid;
    private String tid;
    private Date time;
    private String title;
    private String dirname;
    private int curPage;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid")
    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "tid")
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClazzEntity that = (ClazzEntity) o;
        return Objects.equals(cid, that.cid) &&
                Objects.equals(tid, that.tid) &&
                Objects.equals(time, that.time) &&
                Objects.equals(title, that.title) &&
                Objects.equals(dirname,that.dirname) &&
                Objects.equals(curPage,that.curPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, tid, time, title,dirname,curPage);
    }

    @Basic
    @Column(name = "dirname")
    public String getDirname() {
        return dirname;
    }

    public void setDirname(String dirname) {
        this.dirname = dirname;
    }

    @Basic
    @Column(name = "cur_page")
    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }
}
