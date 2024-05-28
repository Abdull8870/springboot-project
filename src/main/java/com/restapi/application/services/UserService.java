package com.restapi.application.services;

import com.restapi.application.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(User user);

//    Role saveRole(Role role);

//    void addRolesToUser(String username,String rolename);

    Optional<User> getUser(String username);

    List<User> getUsers();

}
