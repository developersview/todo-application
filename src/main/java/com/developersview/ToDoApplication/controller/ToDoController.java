package com.developersview.ToDoApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author pranoy.chakraborty
 * @Date 23/07/22
 */
@Controller
public class ToDoController {

    @RequestMapping(value = "/todo-list", method = RequestMethod.GET)
    public String showTodos(ModelMap model) {
        // model.put("todos", service.retrieveTodos(name));
        return "list-todo";
    }

}
