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
    private Boolean isactive;
    private int points;
    private int pointsUsed;
    private int gold;
    private int silver;
    private int bronze;
    @ManyToMany
    private List<Role> roleList;

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

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
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

    public UserDTO(String email, String name, Boolean isactive, int points, int pointsUsed, int gold, int silver, int bronze) {
        this.email = email;
        this.firstName = name;
        this.isactive = isactive;
        this.points = points;
        this.pointsUsed = pointsUsed;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + firstName + '\'' +
                ", isactive=" + isactive +
                ", points=" + points +
                ", pointsUsed=" + pointsUsed +
                ", gold=" + gold +
                ", silver=" + silver +
                ", bronze=" + bronze +
                '}';
    }

    public static List<UserDTO> createUserDTO(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : userList) {
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(user.getEmail());
            userDTO.setFirstName(user.getFirstname());
            userDTO.setBronze(user.getBadgeList().get(2).getCount());
            userDTO.setGold(user.getBadgeList().get(0).getCount());
            userDTO.setSilver(user.getBadgeList().get(1).getCount());
            userDTO.setIsactive(user.getActive());
            userDTO.setRoleList(user.getRoles());
            userDTO.setId(user.getId());
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }
}
