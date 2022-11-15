package com.tmdb.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)

public class RateMovieResponse {
    private boolean success;
    private String success_message;
    private int status_code;
}
