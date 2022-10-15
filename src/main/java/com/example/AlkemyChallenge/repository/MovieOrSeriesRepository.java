package com.example.AlkemyChallenge.repository;

import com.example.AlkemyChallenge.entity.MovieOrSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieOrSeriesRepository extends JpaRepository<MovieOrSeries, Long> {
}
