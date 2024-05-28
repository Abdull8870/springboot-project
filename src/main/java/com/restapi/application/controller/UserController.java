package com.restapi.application.controller;

import com.restapi.application.services.UserService;
import com.restapi.application.user.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
//    private final RoleRepository roleRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }


//    @PostMapping("/role/save")
//    public ResponseEntity<Role> saveRole(@RequestBody Role role){
//        return ResponseEntity.ok().body(userService.saveRole(role));
//    }
//
//    @PostMapping("/role/addtouser")
//    public ResponseEntity<?> addroleToUser(@RequestBody RoleToUserForm form){
//       userService.addRolesToUser(form.getUsername(),form.getRoleName());
//       return ResponseEntity.ok().build();
//
//    }
//    }


    @Data
    class RoleToUserForm {
        private String username;

        private String roleName;
    }

}