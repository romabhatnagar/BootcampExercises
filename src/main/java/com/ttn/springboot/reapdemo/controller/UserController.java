package com.ttn.springboot.reapdemo.controller;

import com.ttn.springboot.reapdemo.entity.Badge;
import com.ttn.springboot.reapdemo.entity.Recognize;
import com.ttn.springboot.reapdemo.entity.User;
import com.ttn.springboot.reapdemo.entity.UserDTO;
import com.ttn.springboot.reapdemo.service.BadgeService;
import com.ttn.springboot.reapdemo.service.MailService;
import com.ttn.springboot.reapdemo.service.RoleService;
import com.ttn.springboot.reapdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    MailService mailService;
    @Autowired
    BadgeService badgeService;
    @Autowired
    RoleService roleService;

    @GetMapping(value = {"/", "/login"})
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView afterLogin(@ModelAttribute("user") @Valid User user, HttpSession httpSession) {
        User user1 = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
        ModelAndView modelAndView = new ModelAndView();

        if (user1 == null) {
            modelAndView.addObject("message", "These credentials doesnot match with our records");
        } else if (user1.getActive() == false) {
            modelAndView.addObject("message", "Sorry, this user is inactive");
        } else {
            httpSession.setAttribute("userLoggedIn", user1);
            modelAndView.addObject("userData", user1);
            List<Badge> badgeList = getBadge(user1.getId());
            System.out.println("id is" + user1.getId());
            System.out.println(badgeList);
            modelAndView.addObject("userBadge", badgeList);
            modelAndView.setViewName("dashboard");
        }
        return modelAndView;
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @Transactional
    @PostMapping("/dashboard")
    public String dashboard(User user, Recognize recognize, RedirectAttributes redirectAttributes, HttpSession httpSession) {
        redirectAttributes.addFlashAttribute("message", user);
        User loggedInUser = (User) httpSession.getAttribute("userLoggedIn");
        userService.updateUserBadge(recognize, user, httpSession);
        userService.updateLogginUserBadge(loggedInUser, recognize.getCountRecognize());
        return "redirect:/dashboard";
    }


    @GetMapping("/signUp")
    public String signing() {
        return "signUp";
    }

    @GetMapping("/SignOut")
    public String signOut(HttpSession httpSession) {
        httpSession.invalidate();
        return "login";
    }

    @PostMapping("/signUp")
    public ModelAndView postSignUp(@Valid User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        User user1 = userService.findByEmail(user.getEmail());

        if (user1 != null) {
            model.addObject("message", "This email is already regsitered!");
            return model;
        }

        if (bindingResult.hasErrors()) {
            return model;
        } else {
            userService.saveUser(user);
            model.addObject("message", "User has been registered successfully!");
        }
        return model;
    }

    @GetMapping("/forgotPassword")
    public String forgotPassword() {
        return "forgotPassword";
    }

    @PostMapping("/forgotPassword")
    public ModelAndView sendMail(User user) {
        mailService.sendMail(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Email has been sent to " + user.getEmail());
        return modelAndView;

    }

    @RequestMapping(value = "/adminPanel", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView showAdminPanel(Model model) {
        List<User> userList = userService.findAll();
        List<UserDTO> list = UserDTO.createUserDTO(userList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userDtoList", list);
        modelAndView.setViewName("adminPanel");
        System.out.println(UserDTO.createUserDTO(userList));
        return modelAndView;
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findById(id);
        userService.deleteUser(user);
        mailService.sendRevokedMail(user);
        modelAndView.setViewName("adminPanel");
        redirectAttributes.addFlashAttribute("message", "deleted");
        return "redirect:/adminPanel";
    }

    @GetMapping("/editUser/{id}")
    public ModelAndView editUser(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("editUserId", id);
        modelAndView.setViewName("adminUserEdit");
        return modelAndView;
    }

    @Transactional
    @PostMapping("/editUser/{id}")
    public String editUser(@PathVariable Integer id, User user) {
        System.out.println("Hiiiiiii" + id);
        System.out.println("Hiiiiiii user" + user);

        userService.updateUser(id, user.getActive(), user.getRoles());
        return "redirect:/adminPanel";
    }

  /*  public ModelAndView editUser(@PathVariable Integer id, User user){
         ModelAndView modelAndView = new ModelAndView();
     }*/

    @GetMapping("/badge")
    @ResponseBody
    public List<Badge> getBadge(int userid) {
        return badgeService.getBadge(userid);
    }

    @GetMapping("/badgeList")
    public List<Recognize> getBadgeList(User user) {
        User user1 = badgeService.findbyFirstName(user.getFirstname());
        int userid = user1.getId();
        return badgeService.getBadgeList(userid);
    }

    @GetMapping("/badgeIndex")
    public String badge() {
        return "badgeIndex";
    }
}
