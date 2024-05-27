package com.restapi.application.services;

import com.restapi.application.user.Role;
import com.restapi.application.user.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRolesToUser(String username,String rolename);

    User getUser(String username);

    List<User> getUsers();

}
