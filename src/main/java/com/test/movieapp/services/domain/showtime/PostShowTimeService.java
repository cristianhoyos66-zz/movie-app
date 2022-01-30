package com.test.movieapp.services.domain.showtime;

import com.test.movieapp.aggregates.ShowTimeAggregate;
import com.test.movieapp.dtos.requests.ShowTimeRequestDTO;
import com.test.movieapp.dtos.responses.ShowTimeResponseDTO;
import com.test.movieapp.errors.ShowTimeExistsError;
import com.test.movieapp.mappers.ShowTimeMapper;
import io.vavr.control.Either;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PostShowTimeService {

  private final ShowTimeService showTimeService;
  private final ShowTimeMapper showTimeMapper;

  public Either<ShowTimeExistsError, ShowTimeResponseDTO> postShowTime(
      ShowTimeRequestDTO showTimeRequestDTO) {
    return getAggregate(showTimeRequestDTO)
        .flatMap(this::validateAndPostShowTime)
        .flatMap(this::buildResponse);
  }

  private Either<ShowTimeExistsError, ShowTimeAggregate> getAggregate(
      ShowTimeRequestDTO showTimeRequestDTO) {
    return Either.right(ShowTimeAggregate.builder().showTimeRequestDTO(showTimeRequestDTO).build());
  }

  private Either<ShowTimeExistsError, ShowTimeAggregate> validateAndPostShowTime(
      ShowTimeAggregate showTimeAggregate) {
    return showTimeService
        .postShowTime(showTimeAggregate.getShowTimeRequestDTO())
        .map(showTimeId -> showTimeAggregate.toBuilder().showTimeId(showTimeId).build());
  }

  private Either<ShowTimeExistsError, ShowTimeResponseDTO> buildResponse(
      ShowTimeAggregate showTimeAggregate) {
    return Either.right(showTimeMapper.getResponseDTOFromAgg(showTimeAggregate));
  }
}
