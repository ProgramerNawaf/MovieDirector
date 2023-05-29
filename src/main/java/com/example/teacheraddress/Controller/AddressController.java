package com.example.teacheraddress.Controller;

import com.example.teacheraddress.DTO.AddressDTO;
import com.example.teacheraddress.Model.Address;
import com.example.teacheraddress.Model.Teacher;
import com.example.teacheraddress.Service.AddressService;
import com.example.teacheraddress.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity getAddress(){
        return ResponseEntity.status(200).body(addressService.getAddress());
    }
    @PostMapping("/add")
    public ResponseEntity addTeachers(@Valid @RequestBody AddressDTO t){
        addressService.addAddress(t);
        return ResponseEntity.status(200).body("Address added");
    }
    @PutMapping("/update")
    public ResponseEntity updateAddress(@Valid @RequestBody AddressDTO t ){
        addressService.updateAdrress(t,t.getTeacher_Id());
        return ResponseEntity.status(200).body("Address updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("Address deleted!");
    }

}
