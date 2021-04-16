package com.lambdaschool.todos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todos extends Auditable {
    //Fields ---------------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Generated Id
    private long todoid;

    @Column(nullable = false)
    private String description;

    private boolean completed;

    //Many to One ---------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name = "userid",
    nullable = false)
    @JsonIgnoreProperties(value = "todos",
            allowSetters = true)
    private User user;

    //Default Constructor -------------------------------------------------------------
    public Todos() {
    }

    //Single Constructor ---------------------------------------------------------------
    public Todos(User user, String description) {
        this.user = user;
        this.description = description;
        this.completed = false;
    }
    //Getters & Setters ----------------------------------------------------------------
    public long getTodoid() {
        return todoid;
    }

    public void setTodoid(long todoid) {
        this.todoid = todoid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}