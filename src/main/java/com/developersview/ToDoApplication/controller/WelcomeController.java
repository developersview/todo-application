package com.developersview.ToDoApplication.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author pranoy.chakraborty
 * @Date 23/07/22
 */
@Controller
public class WelcomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String showWelcomePage(ModelMap model){
        model.put("name", getLoggedinUserName());
        return "welcome";
    }
    private String getLoggedinUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();
    }
}