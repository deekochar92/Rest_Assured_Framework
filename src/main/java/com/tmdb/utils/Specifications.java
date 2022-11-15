package com.tmdb.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    public static RequestSpecification getRequestSpec() {
        RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri("https://api.themoviedb.org").
                log(LogDetail.ALL).setContentType(ContentType.JSON).
                addQueryParam("api_key", "8f27fe80f784cc088d44f642e123af30").
                build();
        return requestSpec;
    }

    public static ResponseSpecification getResponseSpec() {
        ResponseSpecification responseSpec = new ResponseSpecBuilder().log(LogDetail.ALL).build();
        return responseSpec;
    }
}
