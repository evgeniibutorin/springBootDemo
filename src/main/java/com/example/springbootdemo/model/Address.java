//package com.example.springbootdemo.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table
//@NoArgsConstructor
//@AllArgsConstructor
//public class Address {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Getter
//    @Setter
//    int id;
//
//    @Column(name = "address")
//    private String address;
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")//name - (Необязательно) Имя столбца внешнего ключа. nullable - (Необязательно) Может ли столбец внешнего ключа допускать значение NULL
//    private List<Employee> employees;
//
//    public Address(String address, List<Employee> employees) {
//        this.address = address;
//        this.employees = employees;
//    }
//}
