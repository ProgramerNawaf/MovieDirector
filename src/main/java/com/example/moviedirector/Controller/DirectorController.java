package com.example.moviedirector.Controller;

import com.example.moviedirector.Model.Director;
import com.example.moviedirector.Service.DirectorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/director")
@RequiredArgsConstructor
public class DirectorController {
    private final DirectorService directorService;



    @GetMapping("/get")
    public ResponseEntity getDirectors(){
        return ResponseEntity.status(200).body(directorService.getDirectors());
    }
    //,consumes = MediaType.APPLICATION_JSON_VALUE
    @PostMapping(path = "/create")
    public ResponseEntity addDirector(@Valid @RequestBody Director d ){
        directorService.addDirector(d);
        return ResponseEntity.status(200).body("Director is added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDirector(@Valid @RequestBody Director director , @PathVariable int id){
        directorService.updateDirector(id, director);
        return ResponseEntity.status(200).body("Director is updated!");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDirector(@PathVariable int id) {
        directorService.deleteDirector(id);
        return ResponseEntity.status(200).body("Director is deleted!");
    }
}

