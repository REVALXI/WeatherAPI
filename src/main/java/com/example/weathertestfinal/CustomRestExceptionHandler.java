//package com.example.weathertestfinal;
//
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.NoHandlerFoundException;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import javax.servlet.annotation.WebServlet;
//import java.util.HashMap;
//
//@Order(Ordered.HIGHEST_PRECEDENCE)
//@ControllerAdvice
//public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
//
//
//    @Override
//    protected ResponseEntity<Object> handleNoHandlerFoundException(
//            NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        String error = "No handler found for " + ex.getHttpMethod() + " " + ex.getRequestURL();
//
//        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), error);
//        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
//    }
//
//
//}
//
////@RestControllerAdvice
////public class CustomRestExceptionHandler {
////
////    @ExceptionHandler(NoHandlerFoundException.class)
////    @ResponseStatus(HttpStatus.NOT_FOUND)
////    public HashMap<String, String> handleNoHandlerFound(NoHandlerFoundException e, WebRequest request) {
////        HashMap<String, String> response = new HashMap<>();
////        response.put("status", "fail");
////        response.put("message", e.getLocalizedMessage());
////        return response;
////    }
////}
