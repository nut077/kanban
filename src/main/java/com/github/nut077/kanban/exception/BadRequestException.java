package com.github.nut077.kanban.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BadRequestException extends CommonException {

  public BadRequestException(String message) {
    super(HttpStatus.BAD_REQUEST, String.valueOf(HttpStatus.BAD_REQUEST), message);
  }
}
