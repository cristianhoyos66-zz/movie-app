package com.test.movieapp.services.domain.movie;

import com.test.movieapp.dtos.MovieDTO;
import com.test.movieapp.entities.MovieEntity;
import com.test.movieapp.mappers.MovieMapper;
import com.test.movieapp.repositories.MovieRepository;
import com.test.movieapp.services.domain.external.omdba.OmdbaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.LongStream;

@Service
@AllArgsConstructor
public class MovieService {

  private final OmdbaService omdbaService;
  private final MovieMapper movieMapper;
  private final MovieRepository movieRepository;

  private static final String[] movieIds = {
    "tt0232500",
    "tt0322259",
    "tt0463985",
    "tt1013752",
    "tt1596343",
    "tt1905041",
    "tt2820852",
    "tt4630562",
    "tt5433138"
  };

  public void saveAllFastFuriousMovies() {
    LongStream.of(movieRepository.count())
        .filter(val -> val == 0)
        .forEach(val -> getAndSaveMovies());
  }

  private void getAndSaveMovies() {
    Arrays.stream(movieIds)
        .forEach(movieId -> omdbaService.getMovie("e4f33820", movieId).map(this::saveMovie));
  }

  private MovieEntity saveMovie(MovieDTO movieDTO) {
    var movieEntity = movieMapper.getEntityFromDto(movieDTO);
    return movieRepository.save(movieEntity);
  }
}
