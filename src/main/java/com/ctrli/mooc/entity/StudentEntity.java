package com.ctrli.mooc.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Create by zekdot on 19-5-26.
 */
@Entity
@Table(name = "student", schema = "nju_vivo", catalog = "")
public class StudentEntity {
    private String sid;
    private String password;

    @Id
    @Column(name = "sid")
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(sid, that.sid) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, password);
    }
}
