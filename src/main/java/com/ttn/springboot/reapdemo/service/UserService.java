package com.ttn.springboot.reapdemo.service;

import com.ttn.springboot.reapdemo.entity.Badge;
import com.ttn.springboot.reapdemo.entity.Recognize;
import com.ttn.springboot.reapdemo.entity.Role;
import com.ttn.springboot.reapdemo.entity.User;
import com.ttn.springboot.reapdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Badge gold = new Badge("gold", 3);
        Badge silver = new Badge("silver", 2);
        Badge bronze = new Badge("bronze", 1);
        user.setBadgeList(new ArrayList<Badge>(Arrays.asList(gold, silver, bronze)));
        Recognize take = new Recognize("taken", "Gold", "2");
        user.setRecognizes(new ArrayList<Recognize>(Arrays.asList(take)));
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
        return userRepository.findByFirstname(firstname);
    }

    public void updateUserBadge(Badge badge, Integer counttoadd) {
        userRepository.updateBadge(badge.getId(), badge.getCount() + counttoadd, badge.getType());
    }

    public void updateUser(Integer id, Boolean active, List<Role> roles) {
        userRepository.updateUser(id, active, roles);
    }
}