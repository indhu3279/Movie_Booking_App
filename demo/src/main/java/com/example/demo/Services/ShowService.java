package com.example.demo.Services;


import com.example.demo.model.Show;
import com.example.demo.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public List<Show> findByMovieId(int movieId){
        return showRepository.findByMovieId(movieId);
    }

}
