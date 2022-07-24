package com.developersview.ToDoApplication.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author pranoy.chakraborty
 * @Date 24/07/22
 */
@Entity
@Table(name ="todos")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="targetDate", nullable = false)
    private Date targetDate;

    public ToDo() {
    }

    public ToDo(int id, String description, Date targetDate) {
        this.id = id;
        this.description = description;
        this.targetDate = targetDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                '}';
    }
}
