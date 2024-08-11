package com.example.demo.Services;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovieService{

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> getByMovieId(int movieid){
        return movieRepository.findByMovieId(movieid);
    }
    public List<Movie> findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public List<Movie> getByLanguage(String language){
        return movieRepository.findByLanguage(language);
    }

//    public List<Movie> getByReleasedate(Date releasedate){
//        return movieRepository.findByReleasedate(releasedate);
//    }

    public List<Movie> getByCountry(String country){
        return movieRepository.findByCountry(country);
    }

    public List<Movie> getByGenre(String genre){
        return movieRepository.findByGenre(genre);
    }
}
