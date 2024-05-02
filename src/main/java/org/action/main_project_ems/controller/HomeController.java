package org.action.main_project_ems.controller;

import javax.servlet.http.HttpSession;
import org.action.main_project_ems.model.UserDtls;
import org.action.main_project_ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/createuser")
    public String createuser(@ModelAttribute UserDtls user, HttpSession session){

        //System.out.println(user);
        boolean f = userService.checkEmail(user.getEmail());
        if(f){
            session.setAttribute("msg","Email id already Exist");
        } else {
            UserDtls userDtls = userService.createUser(user);
            if(userDtls !=null)
            {
                session.setAttribute("msg","Registered Successfully");
            }else{
                session.setAttribute("msg","Error Occurred");
            }
        }
        return "redirect:/signin";
    }
}
