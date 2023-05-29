package com.example.teacheraddress.Service;

import com.example.teacheraddress.ApiException.ApiException;
import com.example.teacheraddress.DTO.AddressDTO;
import com.example.teacheraddress.Model.Address;
import com.example.teacheraddress.Model.Teacher;
import com.example.teacheraddress.Repo.AddressRepo;
import com.example.teacheraddress.Repo.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepo addressRepo;
    private final TeacherRepo teacherRepo;

    public List<Address> getAddress(){
        return addressRepo.findAll();
    }

    public void addAddress(AddressDTO dto) {
        if (teacherRepo.findTeacherById(dto.getTeacher_Id()) == null)
            throw new ApiException("No teacher with this id!");

        Address a = new Address(null,dto.getArea(),dto.getStreet(),dto.getBuildingNumber(),teacherRepo.findTeacherById(dto.getTeacher_Id()));
        addressRepo.save(a);
    }

    public void updateAdrress(AddressDTO dto,Integer id){
        Address a =addressRepo.findAddressById(id);
        if(a == null)
            throw new ApiException("no teacher with this id!");
        a.setArea(dto.getArea());
        a.setStreet(dto.getStreet());
        a.setBuildingNumber(dto.getBuildingNumber());
        addressRepo.save(a);
    }

    public void deleteAddress(Integer id){
        Address a =addressRepo.findAddressById(id);
        if(a == null)
            throw new ApiException("no teacher with this id!");
        Teacher t = a.getTeacher();
        t.setAddress(null);
        addressRepo.delete(a);

    }
}
