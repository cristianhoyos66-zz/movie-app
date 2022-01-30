package com.test.movieapp.errors;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

@Getter
public class ShowTimeExistsError extends HttpStatusCodeException {

  private ShowTimeExistsError(String dateTime) {
    super(HttpStatus.BAD_REQUEST, String.format("Show Time %s is already Setup", dateTime));
  }

  public static ShowTimeExistsError of(String dateTime) {
    return new ShowTimeExistsError(dateTime);
  }
}
