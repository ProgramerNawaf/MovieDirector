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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(25) not null")
    @NotNull(message = "name cant be null")
    private String name;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "teacher_id",referencedColumnName = "id")
    private Teacher teacherCourses;
    @ManyToMany
    @JsonIgnore
    private Set<Student> students;
}
