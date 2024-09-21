package com.auto.inventorymanagement.controllers;

import com.auto.inventorymanagement.DTO.assignRoleDTO;
import com.auto.inventorymanagement.models.Role;
import com.auto.inventorymanagement.models.User;
import com.auto.inventorymanagement.repositories.RoleRepository;
import com.auto.inventorymanagement.repositories.UserRepository;
import com.auto.inventorymanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private RestTemplate restTemplate;


    @Autowired
    public UserController(UserService userService,
                          RestTemplate restTemplate
                          ) {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }
    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody User user) {
        ResponseEntity<User> response = new ResponseEntity<>(
                userService.signUp(user), HttpStatus.CREATED
        );
        return response;
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> users = userService.getAllUser();
//        List<User> allUsers = new ArrayList<>();
//        for(User u: users) {
//            users.add(u);
//        }
        ResponseEntity<List<User>> response = new ResponseEntity<>(
                users, HttpStatus.FOUND
        );
        return response;
    }
    @PostMapping("addRole")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        ResponseEntity<Role> response = new ResponseEntity<>(
                userService.createRole(role),HttpStatus.CREATED
        );
        return response;
    }
    @GetMapping("/role")
    public ResponseEntity<List<Role>> getAllRole() {
        ResponseEntity<List<Role>> response = new ResponseEntity<>(
                userService.getAllRole(),HttpStatus.FOUND
        );
        return response;
    }
    @PatchMapping("/assignRole")
    public ResponseEntity<List<User>> assignRole(@RequestBody assignRoleDTO request) {
                ResponseEntity<List<User>> response = new ResponseEntity<>(
                userService.assignRole(request.getId(), request.getRole()), HttpStatus.CREATED
        );
        return response;
    }
}
