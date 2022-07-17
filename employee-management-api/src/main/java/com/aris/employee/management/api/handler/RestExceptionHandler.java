package com.aris.employee.management.api.handler;

import com.aris.employee.management.api.dto.EmptyResponseDTO;
import com.aris.employee.management.api.exception.AttributeExistsException;
import com.aris.employee.management.api.rest.ApiResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        ApiResponse<EmptyResponseDTO> response = new ApiResponse<>(new EmptyResponseDTO(), status);

        StringBuilder builder = new StringBuilder();

        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
                    builder.append("Field ");
                    builder.append(fieldError.getField());
                    builder.append(" ");
                    builder.append(fieldError.getDefaultMessage());
//                    builder.append("\n");
                    builder.append(", ");
                }
        );

        String result = builder.toString();
        response.setErrorMessage(result.substring(0, result.length() - 2));

        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @ExceptionHandler(AttributeExistsException.class)
    protected ResponseEntity<ApiResponse<EmptyResponseDTO>> handleAttributeExistsException(AttributeExistsException ex) {
        ApiResponse<EmptyResponseDTO> response = new ApiResponse<>(new EmptyResponseDTO(), HttpStatus.BAD_REQUEST);

        response.setErrorMessage("Attribute already exists with provided values");

        return new ResponseEntity<>(response, response.getHttpStatus());
    }


}
