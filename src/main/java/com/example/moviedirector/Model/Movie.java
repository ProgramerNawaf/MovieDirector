package com.example.moviedirector.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@Data
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(20) not null unique")
    @NotNull(message = "name cant be empty!")
    @Size(min= 2 , message = "name must be longer than 2 charchters!")
    private String name;
    @Column(columnDefinition = "varchar(20) not null check (genre='drama' or genre='action' or genre='comedy')")
    @NotNull(message = "genre cant be empty!")
    private String genre;
    @Column(columnDefinition = "int not null CHECK (rating > 0 and rating < 6)")
    @NotNull(message = "rating cant be empty!")
    @Min(value = 0,message = "rating must be between 1-5")
    @Max(value = 6,message = "rating must be between 1-5")
    private Integer rating;
    @Column(columnDefinition = "int not null CHECK (duration > 60)")
    @Min(60)
    @NotNull(message = "duration cant be empty!")
    private Integer duration;
    @Column(columnDefinition = "int not null")
    @NotNull(message = "duration cant be empty!")
    private Integer directorID;
}
