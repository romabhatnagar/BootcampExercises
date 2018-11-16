package com.ttn.springboot.reapdemo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "recognize")
public class Recognize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String countRecognize;
    private String name;
    private String karma;
    private String reason;
    private String givenTo;
    private String takenFrom;
    private Date timeStamp;

    public String getGivenTo() {
        return givenTo;
    }

    public void setGivenTo(String givenTo) {
        this.givenTo = givenTo;
    }

    public Recognize(String type, String countRecognize, String name, String karma, String reason, String givenTo, String takenFrom, Date timeStamp) {
        this.type = type;
        this.countRecognize = countRecognize;
        this.name = name;
        this.karma = karma;
        this.reason = reason;
        this.givenTo = givenTo;
        this.takenFrom = takenFrom;
        this.timeStamp = timeStamp;
    }

    public Recognize() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountRecognize() {
        return countRecognize;
    }

    public void setCountRecognize(String countRecognize) {
        this.countRecognize = countRecognize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTakenFrom() {
        return takenFrom;
    }

    public void setTakenFrom(String takenFrom) {
        this.takenFrom = takenFrom;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Recognize{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", countRecognize='" + countRecognize + '\'' +
                ", name='" + name + '\'' +
                ", karma='" + karma + '\'' +
                ", reason='" + reason + '\'' +
                ", givenTo='" + givenTo + '\'' +
                ", takenFrom='" + takenFrom + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
