package com.tmdb.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.tmdb.payloads.RateMoviePayload;
import com.tmdb.pojos.Error_Response;
import com.tmdb.pojos.RateMovieResponse;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.io.IOException;

public class PostRateMovieTests {
    RateMoviePayload RM = new RateMoviePayload();
    RateMovieResponse rate_movie_response = new RateMovieResponse();
    Error_Response errorResponse = new Error_Response();


    @Test(description = "TC01 Valid payload  - Should return 200 OK response")
    @Description("Test Description: Valid payload  - Should return 200 OK response ")
    public void TC01_verifyOKResponse_ForAllFields_ValidPayload() throws IOException {
        rate_movie_response = RM.postRateMovie_AllFields_ValidPayload( 7,851644);
        assertThat(rate_movie_response.isSuccess(), equalTo(true));
    }
    @Test(description = "TC02 Invalid payload without apikey  - Should return 401 Unauthorised response")
    @Description("Invalid payload without apikey  - Should return 401 Unauthorised response")
    public void TC02_verifyErrorResponse_ForWithoutAPIKey_InValidPayload() throws IOException {
        errorResponse = RM.postRateMovie_withoutAPIKey_InvalidPayload( 7,851644);
        assertThat(errorResponse.isSuccess(),equalTo(false));
        }

    @Test(description = "TC03 Invalid payload without sessionID  - Should return 401 Unauthorised response")
    @Description("Invalid payload without sessionID  - Should return 401 Unauthorised response")
    public void TC03_verifyErrorResponse_ForWithoutSessionID_InValidPayload() throws IOException {
        errorResponse = RM.postRateMovie_withoutSessionID_InvalidPayload( 7,851644);
        assertThat(errorResponse.isSuccess(),equalTo(false));
    }
    @Test(description = "TC04 Invalid payload with invalid movieID  - Should return 404 Resource not found response")
    @Description("Invalid payload without sessionID  - Should return 401 Unauthorised response")
    public void TC04_verifyErrorResponse_ForInvalidMovieID_InValidPayload() throws IOException {
        errorResponse = RM.postRateMovie_InvalidMovieID_InvalidPayload( 7,1);
        assertThat(errorResponse.isSuccess(),equalTo(false));
    }
    @Test(description = "TC05 Invalid payload with invalid sessionID  - Should return 401 Unauthorised response")
    @Description("Invalid payload with invalid sessionID  - Should return 401 Unauthorised response")
    public void TC05_verifyErrorResponse_ForInvalidSessionID_InValidPayload() throws IOException {
        errorResponse = RM.postRateMovie_InvalidSessionID_InvalidPayload( 7,851644);
        assertThat(errorResponse.isSuccess(),equalTo(false));
    }
    @Test(description = "TC06 Invalid payload with invalid APIKey  - Should return 401 Unauthorised response")
    @Description("Invalid payload with invalid APIKey  - Should return 401 Unauthorised response")
    public void TC06_verifyErrorResponse_ForInvalidApiKey_InValidPayload() throws IOException {
        errorResponse = RM.postRateMovie_InvalidApiKey_InvalidPayload( 7,851644);
        assertThat(errorResponse.isSuccess(),equalTo(false));
    }
    @Test(description = "TC07 Invalid payload with value > 10  - Should return 400 bad request response")
    @Description("Test Description: Invalid payload with value > 10 - Should return 400 bad request response")
    public void TC07_verifyErrorResponse_ForValue_GreaterThan10_ValidPayload() throws IOException {
        rate_movie_response = RM.postRateMovie_InvalidValue_InValidPayload( 11,851644);
        assertThat(rate_movie_response.isSuccess(), equalTo(false));
    }

    @Test(description = "TC08 Invalid payload with value = 10  - Should return 400 bad request response")
    @Description("Test Description: Invalid payload with value > 10 - Should return 400 bad request response")
    public void TC08_verifyErrorResponse_ForValue_EqualTo0_ValidPayload() throws IOException {
        rate_movie_response = RM.postRateMovie_InvalidValue_InValidPayload( 0,851644);
        assertThat(rate_movie_response.isSuccess(), equalTo(false));
    }

    @Test(description = "TC09 Invalid payload with value < 0  - Should return 400 bad request response")
    @Description("Test Description: Invalid payload with value > 10 - Should return 400 bad request response")
    public void TC09_verifyErrorResponse_ForValue_LessThan0_ValidPayload() throws IOException {
        rate_movie_response = RM.postRateMovie_InvalidValue_InValidPayload( -1,851644);
        assertThat(rate_movie_response.isSuccess(), equalTo(false));
    }

    @Test(description = "TC10 Invalid payload with value = 0.1  - Should return 400 bad request response")
    @Description("Test Description: Invalid payload with value = 0.1 - Should return 400 bad request response")
    public void TC10_verifyErrorResponse_ForValue_DecimalValue_ValidPayload() throws IOException {
        rate_movie_response = RM.postRateMovie_InvalidValue_InValidPayload( 0.1,851644);
        assertThat(rate_movie_response.isSuccess(), equalTo(false));
    }
}
