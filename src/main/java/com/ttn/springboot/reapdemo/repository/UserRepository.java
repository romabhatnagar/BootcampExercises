package com.ttn.springboot.reapdemo.repository;

import com.ttn.springboot.reapdemo.entity.Badge;
import com.ttn.springboot.reapdemo.entity.Recognize;
import com.ttn.springboot.reapdemo.entity.Role;
import com.ttn.springboot.reapdemo.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAll();

    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);

    User findByFirstName(String firstname);

    void deleteById(Integer id);

    @Query("select badgeList from User u where u.id=:userid")
    List<Badge> findBadges(@Param("userid") int userid);

    @Query("select recognizes from User u where u.id=:id")
    List<Recognize> getBadges(@Param("id") Integer id);

    @Modifying
    @Query("update Recognize r set karma=:karma, reason=:reason, countRecognize=:count where id=:recognizeid")
    void updateRecognize(@Param("recognizeid") Integer recognizeid, @Param("karma") String karma, @Param("reason") String reason,
                         @Param("count") String count);

    @Modifying
    @Query(value = "update badge  set count = :count where type = :type and id=:id", nativeQuery = true)
    void updateBadge(@Param("id") Integer id, @Param("count") Integer count, @Param("type") String badgeType);

    @Modifying
    @Query(value = "update user u set u.isActive=:active,u.roles=:roles where u.id=:id", nativeQuery = true)
    void updateUser(@Param("id") Integer id, @Param("active") Boolean active, @Param("roles") List<Role> roles);

    @Query("select r from Recognize r")
    List<Recognize> getList();

    @Query("select r from Recognize r order by r.timeStamp desc")
    List<Recognize> findRecognizeList();
}

