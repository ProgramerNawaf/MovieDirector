package com.example.moviedirector.Service;

import com.example.moviedirector.ApiException.ApiException;
import com.example.moviedirector.Model.Director;
import com.example.moviedirector.Model.Movie;
import com.example.moviedirector.Repository.DirectorRepository;
import com.example.moviedirector.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie){
        if(directorRepository.findDirectorById(movie.getDirectorID()) == null)
            throw new ApiException("no Director with this ID!");
        movieRepository.save(movie);
    }

    public void updateMovie(Integer id , Movie movie){
        Movie m= movieRepository.findMovieById(id);
        if(m==null)
            throw new ApiException("no Movie with this ID!");

        m.setName(movie.getName());
        m.setGenre(movie.getGenre());
        m.setDuration(movie.getDuration());
        m.setRating(movie.getRating());
        m.setDirectorID(movie.getDirectorID());
        movieRepository.save(m);
    }

    public void deleteMovie(Integer id){
        if(movieRepository.findMovieById(id)==null)
            throw new ApiException("no Movie with this ID!");
        movieRepository.delete(movieRepository.findMovieById(id));
    }

    public Movie searchTitle(String name){
        if(movieRepository.getMovieByTitle(name)==null)
            throw new ApiException("no Movie with this Title name!");

        return movieRepository.getMovieByTitle(name);
    }

    public Integer movieDuration(String name){
        if(movieRepository.getMovieByTitle(name)==null)
            throw new ApiException("no Movie with this Title name!");

        return movieRepository.getMovieByTitle(name).getDuration();
    }
    public String movieDirectorName(String name){
        if(movieRepository.getMovieByTitle(name)==null)
            throw new ApiException("no Movie with this Title name!");

        return directorRepository.findDirectorById(movieRepository.getMovieByTitle(name).getDirectorID()).getName();
    }

    public List<Movie> directorMovies(String directorName){
        if(directorRepository.findDirectorByName(directorName) == null)
            throw new ApiException("no Director with this name!");
        if(movieRepository.getMoviesByDriector(directorRepository.findDirectorByName(directorName).getId()).isEmpty())
            throw new ApiException("this Director has no movies!");
        return movieRepository.getMoviesByDriector(directorRepository.findDirectorByName(directorName).getId());
    }

    public Integer getMovieRating(String name){
        if(movieRepository.getMovieByTitle(name)==null)
            throw new ApiException("no Movie with this Title name!");
        return movieRepository.getMovieByTitle(name).getRating();
    }

    public List<Movie> getMoviesHigherRating(Integer rating){
        if(!(rating>0 && rating <6))
            throw new ApiException("invalid rating!");
        return movieRepository.getMoviesByRating(rating);
    }

    public List<Movie> getMoviesByGenre(String genre){
        if(movieRepository.findMovieByGenre(genre).isEmpty())
            throw new ApiException("no such Movies with this genre");
        return movieRepository.findMovieByGenre(genre);
    }

}
