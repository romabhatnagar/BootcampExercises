package com.ttn.springboot.reapdemo.service;

import com.ttn.springboot.reapdemo.entity.*;
import com.ttn.springboot.reapdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
//        user.setRecognizes(new ArrayList<Recognize>(Arrays.asList(take)));
        userRepository.save(user);
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

   /* public void updateUserBadge(Badge badge, Integer counttoadd) {
        userRepository.updateBadge(badge.getId(), badge.getCount() + counttoadd, badge.getType());
    }*/

    public void updateUserBadge(Recognize recognize, User user, HttpSession httpSession) {
        String countRecognize = recognize.getCountRecognize();
        User updateUser = findByFirstName(user.getFirstName());
        if (updateUser != null) {
            String takenFromUser = updateUser.getFirstName();
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
            String karma = recognize.getKarma();
            String reason = recognize.getReason();
            String count = recognize.getCountRecognize();
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

 /*   public List<Recognize> getRecognizeList() {
        return userRepository.getList();
    }*/
 public List<Recognize> findUserRecognizeforAllBadges(String name) {
     return userRepository.find(name);
 }

    public List<Recognize> findUserRecognizeForSharedBadges(String name) {
        return userRepository.findAllByRecognizeName(name);
    }

    public List<Recognize> findUserRecognizeforReceivedBadges(String givenTo) {
        return userRepository.findAllByGivenTo(givenTo);
    }


}