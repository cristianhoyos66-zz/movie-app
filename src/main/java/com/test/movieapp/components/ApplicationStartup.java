package com.test.movieapp.components;

import com.test.movieapp.services.domain.movie.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

  private final MovieService movieService;

  /**
   * This event is executed as late as conceivably possible to indicate that the application is
   * ready to service requests.
   */
  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {
    movieService.saveAllFastFuriousMovies();
  }
}
