package com.learning.firstspringapi.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Category extends BaseModel{

    private String title;

    private String description;
}
