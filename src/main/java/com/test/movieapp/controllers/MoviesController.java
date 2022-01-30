package com.test.movieapp.controllers;

import com.test.movieapp.dtos.responses.MovieResponseDTO;
import com.test.movieapp.entities.MovieEntity;
import com.test.movieapp.services.domain.movie.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MoviesController {

  private final MovieService movieService;

  @GetMapping
  @Operation(
      summary = "Find all movies",
      description = "Find all movies with show times",
      tags = {"Movies Controller"})
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "successful operation",
            content =
                @Content(
                    array =
                        @ArraySchema(schema = @Schema(implementation = MovieEntity.class))))
      })
  public ResponseEntity<List<MovieEntity>> getAllMovies() {
    return ResponseEntity.ok(movieService.getAllMovies());
  }
}
