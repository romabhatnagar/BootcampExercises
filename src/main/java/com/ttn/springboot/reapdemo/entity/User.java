package com.ttn.springboot.reapdemo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String password;
    @Column(name = "Is_Active", columnDefinition = "boolean default true", nullable = false)
    private Boolean isActive = true;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_badge", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "badge_id"))
    private List<Badge> badgeList;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_recognize", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "recognize_id"))
    private List<Recognize> recognizes;
    private Integer goldEarned;
    private Integer silverEarned;
    private Integer bronzeEarned;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGoldEarned() {
        return goldEarned;
    }

    public void setGoldEarned(Integer goldEarned) {
        this.goldEarned = goldEarned;
    }

    public Integer getSilverEarned() {
        return silverEarned;
    }

    public void setSilverEarned(Integer silverEarned) {
        this.silverEarned = silverEarned;
    }

    public Integer getBronzeEarned() {
        return bronzeEarned;
    }

    public void setBronzeEarned(Integer bronzeEarned) {
        this.bronzeEarned = bronzeEarned;
    }

    public List<Badge> getBadgeList() {
        return badgeList;
    }

    public void setBadgeList(List<Badge> badgeList) {
        this.badgeList = badgeList;
    }

    public List<Recognize> getRecognizes() {
        return recognizes;
    }

    public void setRecognizes(List<Recognize> recognizes) {
        this.recognizes = recognizes;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", roles=" + roles +
                ", badgeList=" + badgeList +
                ", recognizes=" + recognizes +
                ", goldEarned=" + goldEarned +
                ", silverEarned=" + silverEarned +
                ", bronzeEarned=" + bronzeEarned +
                '}';
    }
}
