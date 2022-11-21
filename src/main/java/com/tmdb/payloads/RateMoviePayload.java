package com.tmdb.payloads;

import com.tmdb.constants.Endpoints;
import com.tmdb.pojos.Error_Response;
import com.tmdb.pojos.RateMovieRequest;
import com.tmdb.pojos.RateMovieResponse;
import com.tmdb.utils.PropertyLoader;

import java.io.IOException;

import static com.tmdb.utils.Specifications.getRequestSpec;
import static com.tmdb.utils.Specifications.getResponseSpec;
import static io.restassured.RestAssured.*;

public class RateMoviePayload extends PropertyLoader {
    RateMovieRequest rateMovie = new RateMovieRequest();

    public RateMovieResponse postRateMovie_AllFields_ValidPayload(double value, int movieID) throws IOException {
        rateMovie.setValue(value);
        RateMovieResponse res = given().
                                        spec(getRequestSpec()).
                                        queryParam("session_id", initProperties().getProperty("session_id")).
                                        queryParam("api_key", initProperties().getProperty("api_key")).
                                when().
                                        pathParam("movie_id", movieID).
                                        body(rateMovie).
                                        post(Endpoints.RATE_MOVIE).
                                then().
                                        spec(getResponseSpec()).
                                        statusCode(201).
                                        extract().response().getBody().as(RateMovieResponse.class);
        return res;
    }

    public RateMovieResponse postRateMovie_InvalidValue_InValidPayload(double value, int movieID) throws IOException {
        rateMovie.setValue(value);
        RateMovieResponse res = given().
                                        spec(getRequestSpec()).
                                        queryParam("session_id", initProperties().getProperty("session_id")).
                                        queryParam("api_key", initProperties().getProperty("api_key")).
                                when().
                                        pathParam("movie_id", movieID).
                                        body(rateMovie).
                                        post(Endpoints.RATE_MOVIE).
                                then().
                                        spec(getResponseSpec()).
                                        statusCode(400).
                                        extract().response().getBody().as(RateMovieResponse.class);
        return res;
    }

    public Error_Response postRateMovie_withoutAPIKey_InvalidPayload(int value, int movieID) throws IOException {
        rateMovie.setValue(value);
        Error_Response res = given().
                                    spec(getRequestSpec()).
                                    queryParam("session_id", initProperties().getProperty("session_id")).
                            when().
                                    pathParam("movie_id", movieID).body(rateMovie).
                                    post(Endpoints.RATE_MOVIE).
                            then().
                                    spec(getResponseSpec()).
                                    statusCode(401).
                                    extract().response().getBody().as(Error_Response.class);
        return res;
    }

    public Error_Response postRateMovie_withoutSessionID_InvalidPayload(int value, int movieID) throws IOException {
        rateMovie.setValue(value);
        Error_Response res = given().
                                    spec(getRequestSpec()).
                                    queryParam("api_key", initProperties().getProperty("api_key")).
                            when().
                                    pathParam("movie_id", movieID).body(rateMovie).
                                    post(Endpoints.RATE_MOVIE).
                            then().
                                    spec(getResponseSpec()).
                                    statusCode(401).
                                    extract().response().getBody().as(Error_Response.class);
        return res;
    }

    public Error_Response postRateMovie_InvalidMovieID_InvalidPayload(int value, int movieID) throws IOException {
        rateMovie.setValue(value);
        Error_Response res = given().
                                    spec(getRequestSpec()).
                                    queryParam("api_key", initProperties().getProperty("api_key")).
                                    queryParam("session_id", initProperties().getProperty("session_id")).
                            when().
                                    pathParam("movie_id", movieID).body(rateMovie).
                                    post(Endpoints.RATE_MOVIE).
                            then().
                                    spec(getResponseSpec()).
                                    statusCode(404).
                                    extract().response().getBody().as(Error_Response.class);
        return res;
    }

    public Error_Response postRateMovie_InvalidSessionID_InvalidPayload(int value, int movieID) throws IOException {
        rateMovie.setValue(value);
        Error_Response res = given().
                                    spec(getRequestSpec()).
                                    queryParam("session_id", initProperties().getProperty("session_id")+"12").
                                    queryParam("api_key", initProperties().getProperty("api_key")).
                            when().
                                    pathParam("movie_id", movieID).body(rateMovie).
                                    post(Endpoints.RATE_MOVIE).
                            then().
                                    spec(getResponseSpec()).
                                    statusCode(401).
                                    extract().response().getBody().as(Error_Response.class);
        return res;
    }

    public Error_Response postRateMovie_InvalidApiKey_InvalidPayload(int value, int movieID) throws IOException {
        rateMovie.setValue(value);
        Error_Response res = given().
                                    spec(getRequestSpec()).
                                    queryParam("session_id", initProperties().getProperty("session_id")).
                                    queryParam("api_key", initProperties().getProperty("api_key"+"12")).
                            when().
                                    pathParam("movie_id", movieID).body(rateMovie).
                                    post(Endpoints.RATE_MOVIE).
                            then().
                                    spec(getResponseSpec()).
                                    statusCode(401).
                                    extract().response().getBody().as(Error_Response.class);
        return res;
    }
}
