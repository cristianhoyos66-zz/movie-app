package com.test.movieapp.mappers;

import com.test.movieapp.dtos.requests.MovieRequestDTO;
import com.test.movieapp.entities.MovieEntity;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

  public MovieEntity getEntityFromDto(MovieRequestDTO movieRequestDTO) {
    return MovieEntity.builder()
        .name(movieRequestDTO.getTitle())
        .description(movieRequestDTO.getPlot())
        .releasedDate(movieRequestDTO.getReleased())
        .imdbRating(movieRequestDTO.getImdbRating())
        .runtime(movieRequestDTO.getRuntime())
        .build();
  }
}
