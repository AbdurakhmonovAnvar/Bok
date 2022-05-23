package com.team.Bok.exception;

import org.springframework.http.ResponseEntity;

public class GlobalExceptionHandler {
    public ResponseEntity<?> exception(BadRequest a){
        return ResponseEntity.badRequest().body(a.getMessage());
    }

}
