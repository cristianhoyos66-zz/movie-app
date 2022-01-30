package com.test.movieapp.mappers;

import com.test.movieapp.aggregates.ShowTimeAggregate;
import com.test.movieapp.dtos.requests.ShowTimeRequestDTO;
import com.test.movieapp.dtos.responses.ShowTimeResponseDTO;
import com.test.movieapp.entities.ShowTimeEntity;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class ShowTimeMapper {

  public ShowTimeEntity getEntityFromReqDto(ShowTimeRequestDTO showTimeRequestDTO) {
    return ShowTimeEntity.builder()
        .idMovie(showTimeRequestDTO.getIdMovie())
        .showTime(OffsetDateTime.parse(showTimeRequestDTO.getShowTime()))
        .build();
  }

  public ShowTimeResponseDTO getResponseDTOFromAgg(ShowTimeAggregate showTimeAggregate) {
    var showTimeReq = showTimeAggregate.getShowTimeRequestDTO();
    return ShowTimeResponseDTO.builder()
        .showTime(showTimeReq.getShowTime())
        .idMovie(showTimeReq.getIdMovie())
        .idShowTime(showTimeAggregate.getShowTimeId())
        .build();
  }
}
