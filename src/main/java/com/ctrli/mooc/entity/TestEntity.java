package com.ctrli.mooc.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Create by zekdot on 19-5-26.
 */
@Entity
@Table(name = "test", schema = "nju_vivo", catalog = "")
public class TestEntity {
    private int id;
    private String test;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "test")
    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestEntity that = (TestEntity) o;
        return id == that.id &&
                Objects.equals(test, that.test);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, test);
    }
}
