package com.example.AlkemyChallenge.service.impl;

import com.example.AlkemyChallenge.entity.MovieOrSeries;
import com.example.AlkemyChallenge.exception.ResourceNotFoundException;
import com.example.AlkemyChallenge.repository.MovieOrSeriesRepository;
import com.example.AlkemyChallenge.service.MovieOrSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieOrSeriesServiceImpl implements MovieOrSeriesService {

    @Autowired
    MovieOrSeriesRepository movieOrSeriesRepository;

    @Override
    public MovieOrSeries saveMovieOrSeries(MovieOrSeries movieOrSeries) {
        return movieOrSeriesRepository.save(movieOrSeries);
    }

    @Override
    public List<MovieOrSeries> saveMoviesOrSeries(List<MovieOrSeries> moviesOrSeries) {
        return movieOrSeriesRepository.saveAll(moviesOrSeries);
    }

    @Override
    public MovieOrSeries getMovieOrSeriesById(Long id) {

        return movieOrSeriesRepository.findById(id).get();
    }

    @Override
    public List<MovieOrSeries> getAllMoviesAndSeries() {
        List<MovieOrSeries> moviesOrSeries = movieOrSeriesRepository.findAll();
        return moviesOrSeries;
    }

    @Override
    public MovieOrSeries updateMovieOrSeries(MovieOrSeries movieOrSeries, long id) {
        return movieOrSeriesRepository.save(movieOrSeries);
    }

    @Override
    public String deleteMovieOrSeries(Long id){
        if(movieOrSeriesRepository.findById(id).isPresent()){
            movieOrSeriesRepository.deleteById(id);
            return "Movie or Series with id: " + id + " has been successfully deleted";
        } else
            throw new ResourceNotFoundException("Movie or Series with id: " + id + " doesn't exist");

    }
}
