package com.example.teacheraddress.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "name cant be null!")
    private String name;
    @NotNull(message = "age cant be null!")
    private Integer age;
    @NotNull(message = "name cant be null!")
    private String major;

    @ManyToMany(mappedBy = "students" , cascade = CascadeType.DETACH)
    private Set<Course> courses;
}
