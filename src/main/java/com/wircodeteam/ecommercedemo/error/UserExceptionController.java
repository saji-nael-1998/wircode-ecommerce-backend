package com.wircodeteam.ecommercedemo.error;


import com.wircodeteam.ecommercedemo.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class UserExceptionController {


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundHandler(UserNotFoundException ex, WebRequest request) {
        return  prepareRestException(ex.getMessage(),ex,request,HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ErrorResponse> prepareRestException(String title, Exception ex, WebRequest request, HttpStatus httpStatus) {
        ErrorResponse apiError = new ErrorResponse();
        apiError.setTitle(title);
        apiError.setHttpStatus(httpStatus.value());
        apiError.setPath(((ServletWebRequest) request)
                .getRequest()
                .getRequestURI());
        apiError.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(apiError, httpStatus);
    }
}
