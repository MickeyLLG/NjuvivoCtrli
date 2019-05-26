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
    private int cid;
    private String tid;
    private Date time;
    private String title;
    private String dirname;
    private int curPage;
    private int pageNum;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cid")
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
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

    @Basic
    @Column(name = "page_num")
    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClazzEntity that = (ClazzEntity) o;
        return cid == that.cid &&
                curPage == that.curPage &&
                Objects.equals(tid, that.tid) &&
                Objects.equals(time, that.time) &&
                Objects.equals(title, that.title) &&
                Objects.equals(dirname, that.dirname) &&
                Objects.equals(pageNum, that.pageNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, tid, time, title, dirname, curPage, pageNum);
    }
}
