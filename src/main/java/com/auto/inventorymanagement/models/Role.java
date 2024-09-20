package com.auto.inventorymanagement.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class Role extends BaseModel{
    private String title;
    private String description;

}
