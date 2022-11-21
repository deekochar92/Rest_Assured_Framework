package com.tmdb.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

public class RateMovieRequest {
@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)

private double value;

}
