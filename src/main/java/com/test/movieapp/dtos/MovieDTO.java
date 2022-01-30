package com.test.movieapp.dtos;

import lombok.Data;

@Data
public class MovieDTO {

  private String title;
  private String plot;
  private String released;
  private String imdbRating;
  private String runtime;
}
