package com.ttn.spring.RestSpringExercise;

public class Post {
    private Long id;
    private Long i;
    private String title;
    private String description;

    public Post(Long id, Long i, String title, String description) {
        this.id = id;
        this.i = i;
        this.title = title;
        this.description = description;
    }
}
