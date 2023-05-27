package com.example.moviedirector.Service;

import com.example.moviedirector.ApiException.ApiException;
import com.example.moviedirector.Model.Director;
import com.example.moviedirector.Repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {

    private final DirectorRepository directorRepository;

    public List<Director> getDirectors(){
        return directorRepository.findAll();
    }

    public void addDirector(Director d){
        directorRepository.save(d);
    }

    public void updateDirector(Integer id , Director newDirector){
       Director d= directorRepository.findDirectorById(id);
        if(d==null)
            throw new ApiException("no Director with this ID!");

        d.setName(newDirector.getName());
        directorRepository.save(d);
    }

    public void deleteDirector(Integer id){
        if(directorRepository.findDirectorById(id)==null)
            throw new ApiException("no Director with this ID!");
        directorRepository.delete(directorRepository.findDirectorById(id));
    }


}
