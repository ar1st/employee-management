package com.aris.employee.management.api.rest;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Setter @Getter
public class ApiResponse<T> {

    private T data;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime timestamp;

    private String errorMessage;

    private HttpStatus httpStatus;

    public ApiResponse() {
        this.httpStatus = HttpStatus.OK;
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this.data = data;
        httpStatus = HttpStatus.OK;
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(T data, HttpStatus httpStatus) {
        this.data = data;
        this.httpStatus = httpStatus;
        this.timestamp = LocalDateTime.now();
    }
}