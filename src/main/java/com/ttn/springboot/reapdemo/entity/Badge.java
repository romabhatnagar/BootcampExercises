package com.ttn.springboot.reapdemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "badge")
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private Integer count;

    public Badge() {
    }

    public Badge(String type, Integer count) {

        this.type = type;
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Badge{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", count=" + count +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
