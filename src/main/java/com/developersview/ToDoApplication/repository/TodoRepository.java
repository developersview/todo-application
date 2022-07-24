package com.developersview.ToDoApplication.repository;

import com.developersview.ToDoApplication.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author pranoy.chakraborty
 * @Date 24/07/22
 */
@Repository
public interface TodoRepository extends JpaRepository<ToDo, Integer> {
}
