package com.lele.management.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Book {

    @Id
    private Integer id;
    private String name;
    private String author;
}