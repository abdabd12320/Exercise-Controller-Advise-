package com.example.thetouringsuppliessystem.Advice;

import com.example.thetouringsuppliessystem.Api.ApiException;
import com.example.thetouringsuppliessystem.Api.ApiResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.sql.SQLIntegrityConstraintViolationException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    // Our Exception
//    @ExceptionHandler(value = ApiException.class)
//    public ResponseEntity ApiException(ApiException e){
//        return ResponseEntity.status(400).body(e.getMessage());
//    }
//
//    // Server Validation Exception
//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiResponse> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        return ResponseEntity.status(400).body(new ApiResponse(e.getFieldError().getDefaultMessage()));
//    }
//
//    // Server Validation Exception
//    @ExceptionHandler(value = ConstraintViolationException.class)
//    public ResponseEntity<ApiResponse> ConstraintViolationException(ConstraintViolationException e) {
//        return ResponseEntity.status(400).body(new ApiResponse(e.getMessage()));
//    }
//
//    // SQL Constraint Ex:(Duplicate) Exception
//    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
//    public ResponseEntity<ApiResponse> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
//        return ResponseEntity.status(400).body(new ApiResponse(e.getMessage()));
//    }
//
//    // wrong write SQL in @column Exception
//    @ExceptionHandler(value = InvalidDataAccessResourceUsageException.class )
//    public ResponseEntity<ApiResponse> InvalidDataAccessResourceUsageException(InvalidDataAccessResourceUsageException e){
//        return ResponseEntity.status(200).body(new ApiResponse(e.getMessage()));
//    }
//
//    // Database Constraint Exception
//    @ExceptionHandler(value = DataIntegrityViolationException.class)
//    public ResponseEntity<ApiResponse> DataIntegrityViolationException(DataIntegrityViolationException e){
//        return ResponseEntity.status(400).body(new ApiResponse(e.getMessage()));
//    }
//
//    // Method not allowed Exception
//    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
//    public ResponseEntity<ApiResponse> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
//        return ResponseEntity.status(400).body(new ApiResponse(e.getMessage()));
//    }
//
//    // Json parse Exception
//    @ExceptionHandler(value = HttpMessageNotReadableException.class)
//    public ResponseEntity<ApiResponse> HttpMessageNotReadableException(HttpMessageNotReadableException e) {
//        return ResponseEntity.status(400).body(new ApiResponse(e.getMessage()));
//    }
//
//    // TypesMisMatch Exception
//    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
//    public ResponseEntity<ApiResponse> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
//        return ResponseEntity.status(400).body(new ApiResponse(e.getMessage()));
//    }
//
//    @ExceptionHandler(value = NoResourceFoundException.class)
//    public ResponseEntity NoResourceFoundException(NoResourceFoundException e)
//    {
//        return ResponseEntity.status(400).body(e.getMessage());
//    }
}
