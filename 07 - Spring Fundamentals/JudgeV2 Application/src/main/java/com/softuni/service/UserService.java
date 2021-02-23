package com.softuni.service;

import com.softuni.model.enitity.RoleNameEnum;
import com.softuni.model.enitity.User;
import com.softuni.model.service.UserServiceModel;
import com.softuni.model.view.UserProfileViewModel;

import java.util.List;

public interface UserService {

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserServiceModel userServiceModel);

    void logout();

    List<String> findAllUsernames();

    void changeRole(String username, RoleNameEnum roleNameEnum);

    User findById(Long id);

    UserProfileViewModel findProfileById(Long id);

}
