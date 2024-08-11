package com.example.demo.controllers;


import com.example.demo.Services.ShowService;
import com.example.demo.model.Show;
import com.example.demo.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @GetMapping("/{movieId}")
    public List<Show> getShowByMovieId(@PathVariable int movieId){
        return showService.findByMovieId(movieId);
    }

}
