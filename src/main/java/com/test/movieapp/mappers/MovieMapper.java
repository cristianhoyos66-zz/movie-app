package com.test.movieapp.mappers;

import com.test.movieapp.dtos.MovieDTO;
import com.test.movieapp.entities.MovieEntity;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

  public MovieEntity getEntityFromDto(MovieDTO movieDTO) {
    return MovieEntity.builder()
        .name(movieDTO.getTitle())
        .description(movieDTO.getPlot())
        .releasedDate(movieDTO.getReleased())
        .imdbRating(movieDTO.getImdbRating())
        .runtime(movieDTO.getRuntime())
        .build();
  }
}
