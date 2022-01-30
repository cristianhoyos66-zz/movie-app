package com.test.movieapp.dtos.requests;

import lombok.Data;

@Data
public class MovieRequestDTO {

  private String title;
  private String plot;
  private String released;
  private String imdbRating;
  private String runtime;
}
