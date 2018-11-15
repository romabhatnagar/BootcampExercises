package com.ttn.springboot.reapdemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "recognize")
public class Recognize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String badgeType;
    private String countRecognize;
    private String karma;
    private String reason;
    private Integer takenFrom;

    public Integer getTakenFrom() {
        return takenFrom;
    }

    public void setTakenFrom(Integer takenFrom) {
        this.takenFrom = takenFrom;
    }

    public String getKarma() {
        return karma;
    }

    public void setKarma(String karma) {
        this.karma = karma;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Recognize() {
    }

    public Recognize(String badgeType, String countRecognize, String karma, String reason, Integer takenFrom) {
        this.badgeType = badgeType;
        this.countRecognize = countRecognize;
        this.karma = karma;
        this.reason = reason;
        this.takenFrom = takenFrom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBadgeType() {
        return badgeType;
    }

    public void setBadgeType(String badgeType) {
        this.badgeType = badgeType;
    }

    public String getCountRecognize() {
        return countRecognize;
    }

    public void setCountRecognize(String countRecognize) {
        this.countRecognize = countRecognize;
    }

    @Override
    public String toString() {
        return "Recognize{" +
                "id=" + id +
                ", badgeType='" + badgeType + '\'' +
                ", countRecognize='" + countRecognize + '\'' +
                ", karma='" + karma + '\'' +
                ", reason='" + reason + '\'' +
                ", takenFrom=" + takenFrom +
                '}';
    }
}
