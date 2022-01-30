package com.test.movieapp.services.domain.external.omdba;

import com.test.movieapp.dtos.MovieDTO;
import com.test.movieapp.errors.FeignClientError;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OmdbaService {

  private final OmdbaClient omdbaClient;

  public Either<FeignClientError, MovieDTO> getMovie(String apiKey, String i) {
    return Try.of(() -> omdbaClient.getMovieByID(apiKey, i))
            .toEither()
            .mapLeft(exc -> FeignClientError.of(exc.getMessage()));
  }
}
