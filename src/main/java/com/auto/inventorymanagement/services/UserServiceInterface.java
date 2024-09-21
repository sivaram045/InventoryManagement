package com.auto.inventorymanagement.services;

import com.auto.inventorymanagement.models.Role;
import com.auto.inventorymanagement.models.User;

import java.util.List;

public interface UserServiceInterface {

    User signUp(User user);

    public User login(String email,
                      String password);
    public String delete(String email);
    public List<User> getAllUser();
    public User getSingleUser(Long Id);
    public User assignRole(Long Id);
    public Role createRole(Role role);
    public List<User> assignRole(Long Id, String role);
    public List<Role> getAllRole();
}
