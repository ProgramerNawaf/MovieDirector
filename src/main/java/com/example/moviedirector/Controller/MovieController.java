package com.example.moviedirector.Controller;

import com.example.moviedirector.Model.Movie;
import com.example.moviedirector.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/get")
    public ResponseEntity getMovies(){
        return ResponseEntity.status(200).body(movieService.getMovies());
    }
    //,consumes = MediaType.APPLICATION_JSON_VALUE
    @PostMapping(path = "/create")
    public ResponseEntity addMovie(@Valid @RequestBody Movie m ){
        movieService.addMovie(m);
        return ResponseEntity.status(200).body("Movie is added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@Valid @RequestBody Movie movie , @PathVariable int id){
        movieService.updateMovie(id, movie);
        return ResponseEntity.status(200).body("Movie is updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable int id) {
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie is deleted!");
    }
    @GetMapping("/search-name/{name}")
    public ResponseEntity searchTitle(@PathVariable String name ){
        return ResponseEntity.status(200).body(movieService.searchTitle(name));
    }
    @GetMapping("/movie-duration/{name}")
    public ResponseEntity movieDuration(@PathVariable String name ){
        return ResponseEntity.status(200).body(movieService.movieDuration(name));
    }
    @GetMapping("/movie-director-name/{name}")
    public ResponseEntity movieDirectorName(@PathVariable String name ){
        return ResponseEntity.status(200).body(movieService.movieDirectorName(name));
    }

    @GetMapping("/director-movies/{directorName}")
    public ResponseEntity directorMovies(@PathVariable String directorName ){
        return ResponseEntity.status(200).body(movieService.directorMovies(directorName));
    }

    @GetMapping("/movie-rating/{name}")
    public ResponseEntity getMovieRating(@PathVariable String name ){
        return ResponseEntity.status(200).body(movieService.getMovieRating(name));
    }
    @GetMapping("/movie-ratings/{rating}")
    public ResponseEntity getMoviesHigherRating(@PathVariable Integer rating ){
        return ResponseEntity.status(200).body(movieService.getMoviesHigherRating(rating));
    }

    @GetMapping("/movie-genre/{genre}")
    public ResponseEntity getMoviesByGenre(@PathVariable String genre ){
        return ResponseEntity.status(200).body(movieService.getMoviesByGenre(genre));
    }

}
