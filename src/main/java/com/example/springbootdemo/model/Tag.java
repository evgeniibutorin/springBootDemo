package com.example.springbootdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tags")
@NoArgsConstructor
@AllArgsConstructor
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Column(name = "tag")
    @Getter
    @Setter
    String tag;

    @Setter
    @Getter
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    //, cascade = CascadeType.ALL
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")//name - (Необязательно) Имя столбца внешнего ключа. nullable - (Необязательно) Может ли столбец внешнего ключа допускать значение NULL referencedColumnName - связывает с полем родительской сущности
    private Employee employee;

}
