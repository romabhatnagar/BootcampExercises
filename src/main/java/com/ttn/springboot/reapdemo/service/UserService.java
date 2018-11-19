package com.ttn.springboot.reapdemo.service;

import com.ttn.springboot.reapdemo.entity.*;
import com.ttn.springboot.reapdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void saveUser(User user) {
        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setRole("user");
        roleList.add(role);
        user.setRoles(roleList);
        user.setSilverEarned(0);
        user.setGoldEarned(0);
        user.setBronzeEarned(0);
        Badge gold = new Badge("gold", 3);
        Badge silver = new Badge("silver", 2);
        Badge bronze = new Badge("bronze", 1);
        user.setBadgeList(new ArrayList<Badge>(Arrays.asList(gold, silver, bronze)));
        userRepository.save(user);
    }

    public Role findRolesId(int id) {
        return userRepository.findRolesId(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

    public User findByFirstName(String firstname) {
        return userRepository.findByFirstName(firstname);
    }

    public void updateUserBadge(Recognize recognize, User user, HttpSession httpSession) {
        String countRecognize = recognize.getCountRecognize();
        User updateUser = findByFirstName(user.getFirstName());
        if (updateUser != null) {
            Integer goldCount = updateUser.getGoldEarned();
            Integer silverCount = updateUser.getSilverEarned();
            Integer bronzeCount = updateUser.getBronzeEarned();

            if (countRecognize.equals("Gold")) {
                updateUser.setGoldEarned(goldCount + 1);
            } else if (countRecognize.equals("Bronze")) {
                updateUser.setBronzeEarned(bronzeCount + 1);
            } else {
                updateUser.setSilverEarned(silverCount + 1);
            }

            User loggedInUser = (User) httpSession.getAttribute("userLoggedIn");
            recognize.setTimeStamp(new Date());
            recognize.setGivenTo(updateUser.getFirstName());
            recognize.setTakenFrom(loggedInUser.getFirstName());
            List<Recognize> recognizeList = new ArrayList<>();
            recognizeList.add(recognize);
            updateUser.setRecognizes(recognizeList);
            userRepository.save(updateUser);
        }

    }

    public void updateUser(Integer id, Boolean active, List<Role> roles) {
        userRepository.updateUser(id, active, roles);
    }

    public void updateLogginUserBadge(User loggedInUser, String countRecognize) {
        User user = loggedInUser;
        String badgeGiven = countRecognize;
        List<Badge> badgeList = user.getBadgeList();

        user.getBadgeList().forEach(badge -> {
            if (badge.getType().equals("gold")) {
                badge.setCount(badge.getCount() - 1);
            }
        });
        userRepository.save(user);
    }

    public List<Recognize> findRecognizeList() {
        return userRepository.findRecognizeList();
    }

    public List<Recognize> findUserRecognizeforAllBadges(String name) {
     return userRepository.find(name);
 }

    public List<Recognize> findUserRecognizeForSharedBadges(String name) {
        return userRepository.findAllByRecognizeName(name);
    }

    public List<Recognize> findUserRecognizeforReceivedBadges(String givenTo) {
        return userRepository.findAllByGivenTo(givenTo);
    }


    public void updateUser(AdminUserDTO adminDTO) {
        User userToUpdate = userRepository.findById(adminDTO.getId());
        if (userToUpdate != null) {
            List<Badge> badgesList = userRepository.findBadges(userToUpdate.getId());
            for (Badge userBadges : badgesList) {
                String badgeType = userBadges.getType();
                if (badgeType.equals("gold")) {
                    int badgeCount = adminDTO.getGoldBadgeCount();
                    int badgeID = userBadges.getId();
                    updateBadgesCount(badgeType, badgeCount, badgeID);
                }
                if (badgeType.equals("silver")) {
                    int badgeCount = adminDTO.getSilverBadgeCount();
                    int badgeID = userBadges.getId();
                    updateBadgesCount(badgeType, badgeCount, badgeID);
                }
                if (badgeType.equals("bronze")) {
                    int badgeCount = adminDTO.getBronzeBadgeCount();
                    int badgeID = userBadges.getId();
                    updateBadgesCount(badgeType, badgeCount, badgeID);
                }
            }
            Role userRoleObject = findRolesId(adminDTO.getId());
            updateRole(userRoleObject.getId(), adminDTO.getRole());
            updateUserActive(adminDTO.getActive(), userToUpdate.getId());
        }
    }

    @Transactional
    public void updateUserActive(Boolean active, int id) {
        userRepository.updateUserActive(active, id);
    }

    @Transactional
    public void updateRole(int id, String roleToUpdate) {
        userRepository.updateRole(id, roleToUpdate);
    }

    @Transactional
    public void updateBadgesCount(String badgeType, int badgeCount, int badgeID) {
        userRepository.updateBadgesCount(badgeType, badgeCount, badgeID);
    }

}