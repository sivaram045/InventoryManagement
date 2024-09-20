package com.auto.inventorymanagement.services;

import com.auto.inventorymanagement.models.Role;
import com.auto.inventorymanagement.models.User;
import com.auto.inventorymanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {
    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }
    @Override
    public User signUp(User user) throws RuntimeException {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if(!optionalUser.isEmpty()) {
            throw new RuntimeException("Email already Exist, Do you want to login?");
        }

        return userRepository.save(user);
    }

    @Override
    public User login(String email, String password) {
        return null;
    }

    @Override
    public String delete(String email) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getSingleUser(Long Id) {
        return null;
    }

    @Override
    public User assignRole(Long Id) {
        return null;
    }

    @Override
    public Role createRole(Role role) {
        return userRepository.save(role);
    }
}
