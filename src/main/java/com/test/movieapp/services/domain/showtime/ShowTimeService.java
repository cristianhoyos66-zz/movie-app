package com.test.movieapp.services.domain.showtime;

import com.test.movieapp.dtos.requests.ShowTimeRequestDTO;
import com.test.movieapp.dtos.responses.ShowTimeResponseDTO;
import com.test.movieapp.errors.ShowTimeExistsError;
import com.test.movieapp.mappers.ShowTimeMapper;
import com.test.movieapp.repositories.ShowTimeRepository;
import io.vavr.control.Either;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class ShowTimeService {

    private final ShowTimeMapper showTimeMapper;
    private final ShowTimeRepository showTimeRepository;

    public Either<ShowTimeExistsError, Integer> postShowTime(ShowTimeRequestDTO showTimeRequestDTO) {
        var showTimeEntity = showTimeMapper.getEntityFromReqDto(showTimeRequestDTO);
        return showTimeRepository.findByShowTime(OffsetDateTime.parse(showTimeRequestDTO.getShowTime()))
                .map(entity -> Either.<ShowTimeExistsError, Integer>left(ShowTimeExistsError.of(showTimeRequestDTO.getShowTime())))
                .orElseGet(() -> Either.right(showTimeRepository.save(showTimeEntity).getId()));

    }

}
