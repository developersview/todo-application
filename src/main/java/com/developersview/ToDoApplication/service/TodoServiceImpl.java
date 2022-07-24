package com.developersview.ToDoApplication.service;

import com.developersview.ToDoApplication.model.ToDo;
import com.developersview.ToDoApplication.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author pranoy.chakraborty
 * @Date 24/07/22
 */
@Service
public class TodoServiceImpl implements TodoService {
    TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @Override
    public List<ToDo> getAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<ToDo> getTodoById(int id) {
        return todoRepository.findById(id);
    }

    @Override
    public void saveTodo(ToDo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void updateTodo(ToDo todo) {
        todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(int id) {
        Optional<ToDo> optional = todoRepository.findById(id);
        if(optional.isPresent()){
            todoRepository.delete(optional.get());
        }
    }
}
