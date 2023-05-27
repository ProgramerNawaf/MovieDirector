package com.example.moviedirector.Repository;

import com.example.moviedirector.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    Movie findMovieById(Integer id);
    @Query("select m from Movie m where m.name = ?1")
    Movie getMovieByTitle(String name);
    @Query("select m from Movie m where m.directorID = ?1")
    List<Movie> getMoviesByDriector(Integer directorId);
    @Query("select m from Movie m where m.rating > ?1")
    List<Movie> getMoviesByRating(Integer rating);

    List<Movie> findMovieByGenre(String genre);
}
