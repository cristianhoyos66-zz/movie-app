package com.test.movieapp.errors;

import lombok.Getter;

@Getter
public class FeignClientError {
  private final RuntimeException runtimeException;

  private FeignClientError(String msg) {
    this.runtimeException =
        new RuntimeException(String.format("Feign Client error with msg %s", msg));
  }

  public static FeignClientError of(String msg) {
    return new FeignClientError(msg);
  }
}
