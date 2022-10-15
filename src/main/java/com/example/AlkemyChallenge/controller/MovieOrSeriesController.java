package com.example.AlkemyChallenge.controller;


import com.example.AlkemyChallenge.entity.MovieOrSeries;
import com.example.AlkemyChallenge.service.MovieOrSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieOrSeriesController {

    @Autowired
    MovieOrSeriesService movieOrSeriesService;

    @PostMapping
    private ResponseEntity addMovieOrSeries(@RequestBody MovieOrSeries movieOrSeries){
        return new ResponseEntity<>(movieOrSeriesService.saveMovieOrSeries(movieOrSeries), HttpStatus.CREATED);
    }

    @PostMapping("/addMany")
    public ResponseEntity<?> addMoviesAndSeries(@RequestBody List<MovieOrSeries> moviesOrSeries) {
        return new ResponseEntity<>(movieOrSeriesService.saveMoviesOrSeries(moviesOrSeries), HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<?> findAllMoviesAndSeries() {
        return new ResponseEntity<>(movieOrSeriesService.getAllMoviesAndSeries(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findMovieOrSeriesById(@PathVariable Long id) {
        return new ResponseEntity<>(movieOrSeriesService.getMovieOrSeriesById(id), HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity updateMovieOrSeries(@RequestBody MovieOrSeries movieOrSeries){
        return new ResponseEntity<>(movieOrSeriesService.saveMovieOrSeries(movieOrSeries), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteMovieOrSerie(@PathVariable Long id){

        return movieOrSeriesService.deleteMovieOrSeries(id);
    }
}
