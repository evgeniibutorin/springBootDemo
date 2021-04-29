package com.example.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
public class Employee {

 //   @Id
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }
}

