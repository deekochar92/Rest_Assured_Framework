package com.tmdb.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)

public class Error_Response {

    private boolean success;
    private String status_message;
    private int status_code;


}
