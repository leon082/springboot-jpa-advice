package com.technical.test.app.controller.advice;

import com.technical.test.app.controller.ItemController;
import com.technical.test.app.dto.ErrorResponse;
import com.technical.test.app.error.Errors;
import com.technical.test.app.error.GenericError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(assignableTypes = {ItemController.class})
public class ItemControllerAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler(GenericError.class)
  public ResponseEntity<ErrorResponse> controlGenericError(GenericError e) {
    e.printStackTrace();
    return ResponseEntity.status(e.getHttpStatus()).body(new ErrorResponse(e.getMessage(), e.getCode()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> controlException(Exception e) {
    e.printStackTrace();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(
        Errors.INTERNAL_SERVER_ERROR.getMessage(), Errors.INTERNAL_SERVER_ERROR.getCode()));
  }

}
