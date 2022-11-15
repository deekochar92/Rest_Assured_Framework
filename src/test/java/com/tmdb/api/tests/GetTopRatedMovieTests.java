package com.tmdb.api.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.tmdb.payloads.TopRatedPayload;
import com.tmdb.pojos.TopRatedMovies;
import org.testng.annotations.Test;

public class GetTopRatedMovieTests {
    TopRatedMovies movieResponse = new TopRatedMovies();
    TopRatedPayload TR = new TopRatedPayload();

    @Test
    public void verifyOKResponseForOnlyMandatory_ValidPayload() {
        movieResponse = TR.getTopRatedMoviesOnlyMandatory_ValidPayload();
        assertThat(movieResponse.getTotal_results(), equalTo(10508)); // Total No can be fetched directly from DB
        assertThat(movieResponse.getResults().get(0).getOriginal_title(),equalTo("20 Century Girl"));
    }
    @Test
    public void verifyOKResponseForAllFields_ValidPayload() {
        movieResponse = TR.getTopRatedMoviesAllFields_ValidPayload();
        assertThat(movieResponse.getTotal_results(), equalTo(10508));
    }
}
