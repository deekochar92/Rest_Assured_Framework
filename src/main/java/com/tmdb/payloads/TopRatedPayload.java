package com.tmdb.payloads;

import com.tmdb.constants.Endpoints;
import com.tmdb.pojos.TopRatedMovies;

import static com.tmdb.utils.Specifications.getRequestSpec;
import static com.tmdb.utils.Specifications.getResponseSpec;
import static io.restassured.RestAssured.*;

public class TopRatedPayload {
    public TopRatedMovies getTopRatedMoviesOnlyMandatory_ValidPayload() {
        TopRatedMovies res = given().spec(getRequestSpec()).
                when().
                get(Endpoints.GET_TOP_RATED_MOVIES).
                then().spec(getResponseSpec()).extract().response().getBody().as(TopRatedMovies.class);
        return res;
    }
    public TopRatedMovies getTopRatedMoviesAllFields_ValidPayload() {
        TopRatedMovies res = given().spec(getRequestSpec()).queryParams("language","en-US","page","1").
                when().
                get(Endpoints.GET_TOP_RATED_MOVIES).
                then().spec(getResponseSpec()).extract().response().getBody().as(TopRatedMovies.class);
        return res;
    }
}
