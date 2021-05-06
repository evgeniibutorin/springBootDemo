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

    @Setter
    @Getter
    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false, referencedColumnName = "id")
    Address address;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public Employee(int id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public Employee(int id, String name, String position, List<Tag> tags) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.tags = tags;
    }

    public Employee(int id, String name, String position, Address address) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.address = address;
    }
}

