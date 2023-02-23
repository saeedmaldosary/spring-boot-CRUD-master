package com.example.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

// Below annotation Create getters and setters etc...
// The client will receive the Exception from this class
public record ApiException(String message,Throwable throwable,HttpStatus httpStatus,ZonedDateTime zonedDateTime) {


}
