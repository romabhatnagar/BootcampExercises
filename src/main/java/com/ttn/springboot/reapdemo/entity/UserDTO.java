package com.ttn.springboot.reapdemo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private int points;
    private int pointsUsed;
    private int gold;
    private int silver;
    private int bronze;
    @ManyToMany
    private List<Role> roleList;

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPointsUsed() {
        return pointsUsed;
    }

    public void setPointsUsed(int pointsUsed) {
        this.pointsUsed = pointsUsed;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze = bronze;
    }

    public UserDTO() {
    }

    public UserDTO(String email, String firstName, String lastName, Boolean isActive, int points, int pointsUsed, int gold, int silver, int bronze, List<Role> roleList) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.points = points;
        this.pointsUsed = pointsUsed;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isActive=" + isActive +
                ", points=" + points +
                ", pointsUsed=" + pointsUsed +
                ", gold=" + gold +
                ", silver=" + silver +
                ", bronze=" + bronze +
                ", roleList=" + roleList +
                '}';
    }

    public static List<UserDTO> createUserDTO(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : userList) {
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(user.getEmail());
            userDTO.setFirstName(user.getFirstName());
            userDTO.setBronze(user.getBadgeList().get(0).getCount());
            userDTO.setGold(user.getBadgeList().get(2).getCount());
            userDTO.setSilver(user.getBadgeList().get(1).getCount());
            userDTO.setActive(user.getActive());
            userDTO.setRoleList(user.getRoles());
            userDTO.setId(user.getId());
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

}
