package com.softuni.model.service;

import com.softuni.model.enitity.Exercise;
import com.softuni.model.enitity.User;

import java.time.LocalDateTime;

public class HomeworkServiceModel {

    private Long id;
    private LocalDateTime addedOn;
    public String gitAddress;
    public UserServiceModel author;

    public HomeworkServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public HomeworkServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public HomeworkServiceModel setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
        return this;
    }

    public String getGitAddress() {
        return gitAddress;
    }

    public HomeworkServiceModel setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
        return this;
    }

    public UserServiceModel getAuthor() {
        return author;
    }

    public HomeworkServiceModel setAuthor(UserServiceModel author) {
        this.author = author;
        return this;
    }
}
