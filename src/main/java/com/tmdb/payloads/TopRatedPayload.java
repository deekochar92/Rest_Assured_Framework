package com.tmdb.payloads;

import com.tmdb.constants.Endpoints;
import com.tmdb.pojos.Error_Response;
import com.tmdb.pojos.TopRatedMovies;
import com.tmdb.utils.PropertyLoader;

import java.io.IOException;

import static com.tmdb.utils.Specifications.getRequestSpec;
import static com.tmdb.utils.Specifications.getResponseSpec;
import static io.restassured.RestAssured.*;

public class TopRatedPayload extends PropertyLoader {
    public TopRatedMovies getTopRatedMoviesWithoutOptional_ValidPayload() throws IOException {
        TopRatedMovies res = given().
                                    spec(getRequestSpec()).
                                    queryParam("api_key",initProperties().getProperty("api_key")).
                             when().
                                    get(Endpoints.GET_TOP_RATED_MOVIES).
                             then().
                                    spec(getResponseSpec()).statusCode(200).extract().response().getBody().as(TopRatedMovies.class);
        return res;
    }
    public TopRatedMovies getTopRatedMoviesAllFields_ValidPayload() throws IOException {
        TopRatedMovies res = given().
                                    spec(getRequestSpec()).
                                    queryParam("language","en-US").
                                    queryParam("page","1").
                                    queryParam("api_key",initProperties().getProperty("api_key")).
                                    queryParam("region","US").
                             when().
                                    get(Endpoints.GET_TOP_RATED_MOVIES).
                             then().
                                    spec(getResponseSpec()).statusCode(200).extract().response().getBody().as(TopRatedMovies.class);
        return res;
    }
    public Error_Response getTopRatedMoviesWithoutAPIKey_InValidPayload() {
        Error_Response res = given().
                                    spec(getRequestSpec()).
                                    queryParam("language","en-US").
                                    queryParam("page","1").
                                    queryParam("region","US").
                            when().
                                    get(Endpoints.GET_TOP_RATED_MOVIES).
                            then().
                                    spec(getResponseSpec()).statusCode(401).extract().response().as(Error_Response.class);
        return res;
    }
    public Error_Response getTopRatedMoviesInvalidAPIKey_InValidPayload() throws IOException {
        Error_Response res = given().
                                    spec(getRequestSpec()).
                                    queryParam("language","en-US").
                                    queryParam("page","1").
                                    queryParam("region","US").
                                    queryParam("api_key",initProperties().getProperty("api_key")+"yz").
                            when().
                                    get(Endpoints.GET_TOP_RATED_MOVIES).
                            then().
                                    spec(getResponseSpec()).
                                    statusCode(401).
                                    extract().response().as(Error_Response.class);
        return res;
    }
    public Error_Response getTopRatedMoviesInvalidResource_InValidPayload() throws IOException {
        Error_Response res = given().
                                    spec(getRequestSpec()).
                                    queryParam("language","en-US").
                                    queryParam("page","1").
                                    queryParam("region","US").
                                    queryParam("api_key",initProperties().getProperty("api_key")).
                            when().
                                    get(Endpoints.GET_TOP_RATED_MOVIES+"zyx").
                            then().
                                    spec(getResponseSpec()).statusCode(404).extract().response().as(Error_Response.class);
        return res;
    }

    public Error_Response getTopRatedMoviesInvalidPageNumber_InValidPayload() throws IOException {
        Error_Response res = given().
                                    spec(getRequestSpec()).
                                    queryParam("language","en-US").
                                    queryParam("page","-1").
                                    queryParam("region","US").
                                    queryParam("api_key",initProperties().getProperty("api_key")).
                            when().
                                    get(Endpoints.GET_TOP_RATED_MOVIES).
                            then().
                                    spec(getResponseSpec()).
                                    statusCode(422).
                                    extract().response().as(Error_Response.class);
        return res;
    }
    public Error_Response getTopRatedMoviesInvalidLanguage_InValidPayload() {
        Error_Response res = given().
                                    spec(getRequestSpec()).
                                    queryParam("language","yz").
                                    queryParam("region","US").
                                    queryParam("page","1").
                                    queryParam("api_key","8f27fe80f784cc088d44f642e123af30").
                            when().
                                    get(Endpoints.GET_TOP_RATED_MOVIES).
                            then().
                                    spec(getResponseSpec()).statusCode(400).extract().response().as(Error_Response.class);
        return res;
    }

    public Error_Response getTopRatedMoviesInvalidRegion_InValidPayload() {
        Error_Response res = given().
                                    spec(getRequestSpec()).
                                    queryParam("language","en-US").
                                    queryParam("region","yz").
                                    queryParam("page","1").
                                    queryParam("api_key","8f27fe80f784cc088d44f642e123af30").
                            when().
                                    get(Endpoints.GET_TOP_RATED_MOVIES).
                            then().
                                    spec(getResponseSpec()).statusCode(400).extract().response().as(Error_Response.class);
        return res;
    }
}
