package com.test.movieapp.aggregates;

import com.test.movieapp.dtos.requests.ShowTimeRequestDTO;
import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class ShowTimeAggregate {

  private ShowTimeRequestDTO showTimeRequestDTO;
  private Integer showTimeId;
}
