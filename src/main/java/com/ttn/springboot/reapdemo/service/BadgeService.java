package com.ttn.springboot.reapdemo.service;

import com.ttn.springboot.reapdemo.entity.Badge;
import com.ttn.springboot.reapdemo.entity.Recognize;
import com.ttn.springboot.reapdemo.entity.User;
import com.ttn.springboot.reapdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BadgeService {
    @Autowired
    UserRepository userRepository;

    public List<Badge> getBadge(Integer userid) {
        return userRepository.findBadges(userid);
    }

    public User findbyFirstName(String firstname) {
        return userRepository.findByFirstname(firstname);
    }

    public List<Recognize> getBadgeList(Integer id) {
        return userRepository.getBadges(id);
    }

   /* @Transactional
    public void updateRecognize(Integer recognizeid, String karma, String reason, String count) {
        userRepository.updateRecognize(recognizeid, karma, reason, count);
    }*/

}
