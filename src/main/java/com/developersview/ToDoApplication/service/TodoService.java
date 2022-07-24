package com.developersview.ToDoApplication.service;

import com.developersview.ToDoApplication.model.ToDo;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author pranoy.chakraborty
 * @Date 24/07/22
 */
public interface TodoService {
    List<ToDo> getAllTodos();
    Optional<ToDo> getTodoById(int id);
    void saveTodo(ToDo todo);
    void updateTodo(ToDo todo);
    void deleteTodo(int id);
}
