package com.example.demo.repository;

import com.example.demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

    List<Movie> findByMovieId(int movieid);
    List<Movie> findByTitle(String title);
    List<Movie> findByLanguage(String language);
//    List<Movie> findByReleasedate(Date releasedate);
    List<Movie> findByCountry(String country);
    List<Movie> findByGenre(String genre);

}
