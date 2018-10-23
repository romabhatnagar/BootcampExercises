package com.ttn.spring.Thymleaf.Controller;

import com.ttn.spring.Thymleaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class Q8UserController {

    //q8
    @GetMapping("/users")
    public String fetchUsers(Model model) {
        model.addAttribute("users", populateUsers());
        return "layouts/users";
    }

    @GetMapping("/user")
    private List populateUsers() {
        List<User> users = Arrays.asList(new User(1L, "user1", true, 230000.0),
                new User(2L, "user2", false, 2300.0),
                new User(3L, "user3", true, 4400.0),
                new User(4L, "user4", false, 7300.0));
        return users;
    }

/*    @PostMapping("/register")
    private String register(@ModelAttribute("user") User user){
        return "users";
    }*/
}
