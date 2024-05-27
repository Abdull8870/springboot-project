package com.restapi.application.services;

import com.restapi.application.user.Role;
import com.restapi.application.user.RoleRepository;
import com.restapi.application.user.User;
import com.restapi.application.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;


import java.util.List;

@CommonsLog
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository userRepo;

    private final RoleRepository roleRepo;


    @Override
    public User saveUser(User user) {
        log.info("Saving new user");
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRolesToUser(String username, String rolename) {
        User user=userRepo.findByUsername(username);
        Role role=roleRepo.findByName(rolename);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
