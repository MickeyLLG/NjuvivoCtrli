package com.ctrli.mooc.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Create by zekdot on 19-5-26.
 */
@Entity
@Table(name = "teacher", schema = "nju_vivo", catalog = "")
public class TeacherEntity {
    private String tid;
    private String password;

    @Id
    @Column(name = "tid")
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherEntity that = (TeacherEntity) o;
        return Objects.equals(tid, that.tid) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, password);
    }
}
