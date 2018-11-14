package com.ttn.springboot.reapdemo.service;

import com.ttn.springboot.reapdemo.entity.Role;
import com.ttn.springboot.reapdemo.entity.User;
import com.ttn.springboot.reapdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    @Autowired
    UserRepository userRepository;

    public User updateRoleUser(User user) {
        User user1 = userRepository.findByEmail(user.getEmail());
        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setRole("user");
        roleList.add(role);
        user1.setRoles(roleList);
        return user1;
    }

    public User updateRoleAdmin(User user) {
        User user1 = userRepository.findByEmail(user.getEmail());
        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setRole("admin");
        roleList.add(role);
        user1.setRoles(roleList);
        return user1;
    }

    public User updateRoleSupervisor(User user) {
        User user1 = userRepository.findByEmail(user.getEmail());
        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setRole("supervisor");
        roleList.add(role);
        user1.setRoles(roleList);
        return user1;
    }

    public User updateRoleHead(User user) {
        User user1 = userRepository.findByEmail(user.getEmail());
        List<Role> roleList = new ArrayList<>();
        Role role = new Role();
        role.setRole("Practice Head");
        roleList.add(role);
        user1.setRoles(roleList);
        return user1;
    }
}
