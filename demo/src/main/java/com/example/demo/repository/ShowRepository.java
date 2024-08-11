package com.example.demo.repository;

import com.example.demo.model.Movie;
import com.example.demo.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long>{

    List<Show> findByMovieId(int movieId);

}
