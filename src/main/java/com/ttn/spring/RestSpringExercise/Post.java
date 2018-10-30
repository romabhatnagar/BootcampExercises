package com.ttn.spring.RestSpringExercise;

public class Post {
    private double id;
    private double userid;
    private String title;
    private String description;

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double getUserid() {
        return userid;
    }

    public void setUserid(double userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Post(double id, double userid, String title, String description) {
        this.id = id;
        this.userid = userid;
        this.title = title;
        this.description = description;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", userid=" + userid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
