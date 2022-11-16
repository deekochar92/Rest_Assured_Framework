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
                build();
        return requestSpec;
    }

    public static ResponseSpecification getResponseSpec() {
        ResponseSpecification responseSpec = new ResponseSpecBuilder().log(LogDetail.ALL).build();
        return responseSpec;
    }
}
