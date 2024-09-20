package com.auto.inventorymanagement.repositories;

import com.auto.inventorymanagement.models.Role;
import com.auto.inventorymanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    Optional<User> findById(Long Id);
    Optional<User> findByEmail(String email);

    User save(User user);
    //Optional<List<User>> findBy(Role role);
    void deleteById(Long Id);
    Role save(Role role);
}
