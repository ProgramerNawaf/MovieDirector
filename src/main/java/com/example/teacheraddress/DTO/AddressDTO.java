package com.example.teacheraddress.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    @NotNull(message = "Teacher id cant be null")
    private Integer teacher_Id;
    @NotNull(message = "area number cant be null")
    private String area;
    @NotNull(message = "street cant be null")
    private String street;
    @NotNull(message = "bulding number cant be null")
    private String buildingNumber;
}
