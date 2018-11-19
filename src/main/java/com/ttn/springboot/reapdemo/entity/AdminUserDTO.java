package com.ttn.springboot.reapdemo.entity;

public class AdminUserDTO {

    private String role;
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private int goldBadgeCount;
    private int silverBadgeCount;
    private int bronzeBadgeCount;
    private Boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getGoldBadgeCount() {
        return goldBadgeCount;
    }

    public void setGoldBadgeCount(int goldBadgeCount) {
        this.goldBadgeCount = goldBadgeCount;
    }

    public int getSilverBadgeCount() {
        return silverBadgeCount;
    }

    public void setSilverBadgeCount(int silverBadgeCount) {
        this.silverBadgeCount = silverBadgeCount;
    }

    public int getBronzeBadgeCount() {
        return bronzeBadgeCount;
    }

    public void setBronzeBadgeCount(int bronzeBadgeCount) {
        this.bronzeBadgeCount = bronzeBadgeCount;
    }

    public AdminUserDTO() {
    }

    public AdminUserDTO(String role, int id, String email, String firstName, String lastName, String password, int goldBadgeCount, int silverBadgeCount, int bronzeBadgeCount, Boolean active) {
        this.role = role;
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.goldBadgeCount = goldBadgeCount;
        this.silverBadgeCount = silverBadgeCount;
        this.bronzeBadgeCount = bronzeBadgeCount;
        this.active = active;
    }

}

