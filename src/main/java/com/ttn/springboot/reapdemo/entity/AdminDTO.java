package com.ttn.springboot.reapdemo.entity;

import java.util.ArrayList;
import java.util.List;

public class AdminDTO {

    private int id;
    private Boolean isactive;
    private String role;
    private int goldCount;
    private int silverCount;
    private int bronzeCount;

    public int getGoldCount() {
        return goldCount;
    }

    public void setGoldCount(int goldCount) {
        this.goldCount = goldCount;
    }

    public int getSilverCount() {
        return silverCount;
    }

    public void setSilverCount(int silverCount) {
        this.silverCount = silverCount;
    }

    public int getBronzeCount() {
        return bronzeCount;
    }

    public void setBronzeCount(int bronzeCount) {
        this.bronzeCount = bronzeCount;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "id=" + id +
                ", isactive=" + isactive +
                ", role='" + role + '\'' +
                ", goldCount=" + goldCount +
                ", silverCount=" + silverCount +
                ", bronzeCount=" + bronzeCount +
                '}';
    }

    public AdminDTO(int id, Boolean isactive, String role, int goldCount, int silverCount, int bronzeCount) {
        this.id = id;
        this.isactive = isactive;
        this.role = role;
        this.goldCount = goldCount;
        this.silverCount = silverCount;
        this.bronzeCount = bronzeCount;
    }

    public static List<AdminUserDTO> createAdminUserDTO(List<User> userList) {
        List<AdminUserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            AdminUserDTO userDTO = new AdminUserDTO();
            userDTOList.add(userDTO);
            userDTO.setRole(user.getRoles().get(0).getRole());
            userDTO.setGoldBadgeCount(user.getBadgeList().get(0).getCount());
            userDTO.setSilverBadgeCount(user.getBadgeList().get(1).getCount());
            userDTO.setBronzeBadgeCount(user.getBadgeList().get(2).getCount());
            userDTO.setId(user.getId());
            userDTO.setActive(user.getActive());
            userDTO.setEmail(user.getEmail());
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastname());
            userDTO.setPassword(user.getPassword());
        }
        return userDTOList;
    }
}
