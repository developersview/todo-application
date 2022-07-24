package com.developersview.ToDoApplication.controller;

import com.developersview.ToDoApplication.model.ToDo;
import com.developersview.ToDoApplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author pranoy.chakraborty
 * @Date 23/07/22
 */
@Controller
public class ToDoController {

    TodoService todoService;

    @Autowired
    public ToDoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Date - dd/MM/yyyy
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/todo-list", method = RequestMethod.GET)
    public String showTodos(ModelMap model) {
        model.put("todos", todoService.getAllTodos());
        return "list-todo";
    }

    @RequestMapping(value = "/add-todo",method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap model){
        model.addAttribute("todo", new ToDo());
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Validated ToDo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }
        todoService.saveTodo(todo);
        return "redirect:/todo-list";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        ToDo todo = todoService.getTodoById(id).get();
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Validated ToDo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo";
        }
        todoService.updateTodo(todo);
        return "redirect:/todo-list";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteTodo(id);
        return "redirect:/todo-list";
    }

}
