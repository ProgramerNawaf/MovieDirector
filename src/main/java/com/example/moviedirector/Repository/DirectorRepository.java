package com.example.moviedirector.Repository;

import com.example.moviedirector.Model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer> {

    Director findDirectorById(Integer id);
    Director findDirectorByName(String name);
}
