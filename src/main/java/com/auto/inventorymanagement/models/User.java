package com.auto.inventorymanagement.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class User extends BaseModel{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id")
    private Role role;
}
