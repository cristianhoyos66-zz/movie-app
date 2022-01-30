package com.test.movieapp.repositories;

import com.test.movieapp.entities.MovieEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<MovieEntity, Integer> {}
