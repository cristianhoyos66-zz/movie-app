package com.test.movieapp.controllers;

import com.test.movieapp.dtos.requests.ShowTimeRequestDTO;
import com.test.movieapp.dtos.responses.ShowTimeResponseDTO;
import com.test.movieapp.services.domain.showtime.PostShowTimeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show-times")
@AllArgsConstructor
public class ShowTimesController {

  private final PostShowTimeService postShowTimeService;

  @PostMapping
  @Operation(
      summary = "Add show times to specific movie",
      description = "Returns error or saved show time",
      tags = {"Show Time Controller"})
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "When Show Time is saved Properly",
            content = @Content(schema = @Schema(implementation = ShowTimeResponseDTO.class))),
        @ApiResponse(
            responseCode = "400",
            description = "Error when showtime for specific movie already exists")
      })
  public ResponseEntity<ShowTimeResponseDTO> postShowTime(
      @Parameter(
              description = "Body which includes idMovie and showtime to be saved",
              required = true)
          @RequestBody
          ShowTimeRequestDTO showTimeRequestDTO) {
    return postShowTimeService
        .postShowTime(showTimeRequestDTO)
        .map(ResponseEntity::ok)
        .getOrElseThrow(
            showTimeExistsError -> {
              throw showTimeExistsError;
            });
  }
}
