package com.tmdb.api.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.tmdb.payloads.RateMoviePayload;
import com.tmdb.pojos.RateMovieResponse;
import org.testng.annotations.Test;

public class PostRateMovieTests {
    RateMoviePayload RM = new RateMoviePayload();
    RateMovieResponse rate_movie_response = new RateMovieResponse();

    @Test
    public void verifyOKResponseForValidPayload() {
        rate_movie_response = RM.RateMovieValidPayload();
        assertThat(rate_movie_response.isSuccess(), equalTo(true));
    }
}
