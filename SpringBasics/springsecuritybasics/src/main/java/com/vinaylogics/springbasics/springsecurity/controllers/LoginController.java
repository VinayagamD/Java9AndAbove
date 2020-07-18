package com.vinaylogics.springbasics.springsecurity.controllers;

import com.vinaylogics.springbasics.springsecurity.models.User;
import com.vinaylogics.springbasics.springsecurity.services.SecurityService;
import com.vinaylogics.springbasics.springsecurity.services.UserService;
import com.vinaylogics.springbasics.springsecurity.validations.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(HttpServletRequest request, @ModelAttribute("userForm") User userForm) {

        userService.save(userForm);

        securityService.autoLogin(request.getSession(true), userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, @ModelAttribute("user") User user){
       if(securityService.autoLogin(request.getSession(true), user.getUsername(), user.getPassword())){
           return "redirect:welcome";
       }else {
           return "redirect:login";
       }
    }

    @GetMapping(value = "/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        User user = new User();
        model.addAttribute("user", user);

        return "login";
    }

    @GetMapping(value = {"/", "/welcome"})
    public ModelAndView welcome(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("user", securityService.getCurrentUser(request.getSession()));
        return modelAndView;
    }

    @PostMapping("logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/login";
    }

}
