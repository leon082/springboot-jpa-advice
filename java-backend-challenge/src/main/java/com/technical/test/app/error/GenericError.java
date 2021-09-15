package com.technical.test.app.error;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericError extends Throwable {

  private HttpStatus httpStatus;
  private String message;
  private String code;

  public GenericError(String message, String code, HttpStatus status) {
    super(message);
    this.httpStatus = status;
    this.message = message;
    this.code = code;

  }

}
