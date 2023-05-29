package com.example.teacheraddress.Model;

import com.example.teacheraddress.DTO.AddressDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Address {
    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(25) not null")
    private String area;
    @Column(columnDefinition = "varchar(25) not null")
    private String street;
    @Column(columnDefinition = "varchar(5) not null")
    private String buildingNumber;
    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}
