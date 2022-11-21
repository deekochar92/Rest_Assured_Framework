package com.tmdb.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import com.tmdb.payloads.TopRatedPayload;
import com.tmdb.pojos.Error_Response;
import com.tmdb.pojos.TopRatedMovies;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetTopRatedMovieTests {
    TopRatedMovies movieResponse = new TopRatedMovies();
    Error_Response errorResponse = new Error_Response();
    TopRatedPayload TR = new TopRatedPayload();


    @Test(description = "TC01 Valid payload without optional fields - Should return 200 OK response")
    @Description("Valid payload without optional fields - Should return 200 OK response")
    public void TC01_verifyOKResponse_WithoutOptional_ValidPayload() throws IOException {
        movieResponse = TR.getTopRatedMoviesWithoutOptional_ValidPayload();
        assertThat(movieResponse.getTotal_results(),greaterThan(0));

    }
    @Test(description = "TC02 Valid payload with All fields - Should return 200 OK response")
    @Description("Valid payload with All fields - Should return 200 OK response")
    public void TC02_verifyOKResponse_AllFields_ValidPayload() throws IOException {
        movieResponse = TR.getTopRatedMoviesAllFields_ValidPayload();
        assertThat(movieResponse.getTotal_results(),greaterThan(0));

    }
    @Test(description = "TC03 Invalid payload without APIKey - Should return 401 error response")
    @Description("Invalid payload without APIKey - Should return 401 error response")
    public void TC03_verifyErrorResponse_WithoutAPIKey_InValidPayload() {
        errorResponse = TR.getTopRatedMoviesWithoutAPIKey_InValidPayload();
        assertThat(errorResponse.getStatus_message(),equalTo("Invalid API key: You must be granted a valid key."));
    }


    @Test(description = "TC04 Invalid payload with Invalid APIKey - Should return 401 Unauthorised response")
    @Description("Invalid payload with Invalid APIKey - Should return 401 Unauthorised response")
    public void TC04_verifyErrorResponse_InvalidAPIKey_InValidPayload() throws IOException {
        errorResponse = TR.getTopRatedMoviesInvalidAPIKey_InValidPayload();
        assertThat(errorResponse.getStatus_message(),equalTo("Invalid API key: You must be granted a valid key."));
    }
    @Test(description = "TC05 Invalid resource url  - Should return 404 resource not found response")
    @Description("Invalid resource url  - Should return 404 resource not found response")
    public void TC05_verifyErrorResponse_InvalidResource_InValidPayload() throws IOException {
        errorResponse = TR.getTopRatedMoviesInvalidResource_InValidPayload();
        assertThat(errorResponse.getStatus_message(),equalTo("The resource you requested could not be found."));
    }

    @Test(description = "TC06 Invalid payload with invalid page parameter  - Should return 422 error response")
    @Description("Invalid payload with invalid page parameter  - Should return 422 error response")
    public void TC06_verifyErrorResponse_InvalidPageNumber_InValidPayload() throws IOException {
        errorResponse = TR.getTopRatedMoviesInvalidPageNumber_InValidPayload();
        assertThat(errorResponse.isSuccess(),equalTo(false));
    }
    //Failing below 2 tests intentionally
    @Test(description = "TC07 Invalid payload with invalid Language parameter  - Should return 400 error response")
    @Description("Invalid payload with invalid Language parameter  - Should return 400 error response")
    public void TC07_verifyErrorResponse_InvalidLanguage_InValidPayload() {
        errorResponse = TR.getTopRatedMoviesInvalidLanguage_InValidPayload();
        assertThat(errorResponse.isSuccess(),equalTo(false));
    }

    @Test(description = "TC08 Invalid payload with invalid Region parameter  - Should return 400 error response")
    @Description("Invalid payload with invalid Region parameter  - Should return 400 error response")
    public void TC08_verifyErrorResponse_InvalidRegion_InValidPayload() {
        errorResponse = TR.getTopRatedMoviesInvalidRegion_InValidPayload();
        assertThat(errorResponse.isSuccess(),equalTo(false));
    }
}
