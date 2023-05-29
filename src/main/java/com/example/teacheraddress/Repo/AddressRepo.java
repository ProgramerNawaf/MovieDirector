package com.example.teacheraddress.Repo;

import com.example.teacheraddress.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends JpaRepository<Address,Integer> {

    Address findAddressById(Integer id);
}