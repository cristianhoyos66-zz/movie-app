package com.test.movieapp.repositories;

import com.test.movieapp.entities.ShowTimeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.Optional;

@Repository
public interface ShowTimeRepository extends CrudRepository<ShowTimeEntity, Integer> {

    Optional<ShowTimeEntity> findByShowTime(OffsetDateTime offsetDateTime);

}
