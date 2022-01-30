package com.test.movieapp.services.domain.external.omdba;

import com.test.movieapp.dtos.requests.MovieRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${omdba.name}", url = "${omdba.url}")
public interface OmdbaClient {
  @GetMapping("/")
  MovieRequestDTO getMovieByID(@RequestParam("apikey") String apiKey, @RequestParam("i") String i);
}
