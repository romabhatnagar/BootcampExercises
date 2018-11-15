package com.ttn.springboot.reapdemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "recognize")
public class RecognizeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String recognizedToName;
    private String recognizedFromName;
    private String reason;
    private String badgeType;

    public String getBadgeType() {
        return badgeType;
    }

    public void setBadgeType(String badgeType) {
        this.badgeType = badgeType;
    }

    public RecognizeDTO() {
    }

    public RecognizeDTO(String recognizedToName, String recognizedFromName, String reason, String badgeType) {
        this.recognizedToName = recognizedToName;
        this.recognizedFromName = recognizedFromName;
        this.reason = reason;
        this.badgeType = badgeType;
    }

    @Override
    public String toString() {
        return "RecognizeDTO{" +
                "id=" + id +
                ", recognizedToName='" + recognizedToName + '\'' +
                ", recognizedFromName='" + recognizedFromName + '\'' +
                ", reason='" + reason + '\'' +
                ", badgeType='" + badgeType + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecognizedToName() {
        return recognizedToName;
    }

    public void setRecognizedToName(String recognizedToName) {
        this.recognizedToName = recognizedToName;
    }

    public String getRecognizedFromName() {
        return recognizedFromName;
    }

    public void setRecognizedFromName(String recognizedFromName) {
        this.recognizedFromName = recognizedFromName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
