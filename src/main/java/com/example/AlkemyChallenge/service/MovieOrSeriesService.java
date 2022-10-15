package com.example.AlkemyChallenge.service;

import com.example.AlkemyChallenge.entity.MovieOrSeries;

import java.util.List;

public interface MovieOrSeriesService {


    MovieOrSeries saveMovieOrSeries(MovieOrSeries movieOrSeries);

    List<MovieOrSeries> saveMoviesOrSeries(List<MovieOrSeries> moviesOrSeries);



    MovieOrSeries getMovieOrSeriesById(Long id);

    List<MovieOrSeries> getAllMoviesAndSeries();

    MovieOrSeries updateMovieOrSeries(MovieOrSeries movieOrSeries, long id);



    String deleteMovieOrSeries(Long id);
}
