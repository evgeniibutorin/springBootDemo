package com.example.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "position")
    @Getter
    @Setter
    private String position;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "employee")
    List<Tag> tags;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public Employee(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }
}

