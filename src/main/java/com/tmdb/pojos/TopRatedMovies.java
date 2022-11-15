package com.tmdb.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class TopRatedMovies {
    private int page;
    private List<TopRatedMovies_Results> results;
    private int total_pages;
    private int total_results;
}