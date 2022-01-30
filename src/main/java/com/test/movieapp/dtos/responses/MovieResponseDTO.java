package com.test.movieapp.dtos.responses;

import lombok.Data;

@Data
public class MovieResponseDTO {

  private String title;
  private String plot;
  private String released;
  private String imdbRating;
  private String runtime;
}
