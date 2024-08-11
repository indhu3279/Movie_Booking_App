package com.example.demo.controllers;


import com.example.demo.Services.MovieService;
import com.example.demo.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }
    @GetMapping("/title/{title}")
    public List<Movie> getMovieByTitle(@PathVariable String title){
        return movieService.findByTitle(title);

    }

    @GetMapping("/id/{movieId}")
    public List<Movie> getMovieByMovieId(@PathVariable int movieid){
        return movieService.getByMovieId(movieid);
    }
    @GetMapping("/language/{language}")
    public List<Movie> getMovieByLanguage(@PathVariable String language){
        return  movieService.getByLanguage(language);
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> getMovieByGenre(@PathVariable String genre){
        return movieService.getByGenre(genre);
    }

    @GetMapping("/country/{country}")
    public List<Movie> getMovieByCountry(@PathVariable String country){
        return movieService.getByCountry(country);
    }

//    @GetMapping("/releasedate/{releasedate}")
//    public List<Movie> getMovieByReleasedate(@PathVariable Date releasedate){
//        return movieService.getByReleasedate(releasedate);
//    }




}
