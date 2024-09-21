package com.auto.inventorymanagement.repositories;

import com.auto.inventorymanagement.models.Role;
import com.auto.inventorymanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAll();
    Role save(Role role);
    @Query(value = "select r from Role r where r.title like %:title%")
    Optional<Role> findByTitle(@Param("title") String title);

    //List<User> findUsersBy(Role role);
}
