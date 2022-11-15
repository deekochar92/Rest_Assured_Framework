package com.tmdb.payloads;

import com.tmdb.constants.Endpoints;
import com.tmdb.pojos.RateMovieRequest;
import com.tmdb.pojos.RateMovieResponse;

import static com.tmdb.utils.Specifications.getRequestSpec;
import static com.tmdb.utils.Specifications.getResponseSpec;
import static io.restassured.RestAssured.*;

public class RateMoviePayload {

    public RateMovieResponse RateMovieValidPayload() {
        RateMovieRequest rateMovie = new RateMovieRequest() ;
        rateMovie.setValue(7);

        RateMovieResponse res = given().spec(getRequestSpec()).queryParam("session_id","87f6bcae83f748255982058f35eb3d3af1e9d57b").
                when().pathParam("movie_id", 851644).body(rateMovie).
                post(Endpoints.RATE_MOVIE).
                then().spec(getResponseSpec()).extract().response().getBody().as(RateMovieResponse.class);
        return res;
    }
}
