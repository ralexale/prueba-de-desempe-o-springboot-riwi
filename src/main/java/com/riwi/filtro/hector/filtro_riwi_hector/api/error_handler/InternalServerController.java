package com.riwi.filtro.hector.filtro_riwi_hector.api.error_handler;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.errors.BaseErrorResponse;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.errors.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerController {
    @ExceptionHandler(CannotCreateTransactionException.class)
    public BaseErrorResponse handleCannotCreateTransactionException(CannotCreateTransactionException ex) {
        return ErrorResponse.builder()
                .message("A transaction could not be opened for the database. Please try again later.")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public BaseErrorResponse handleGlobalException(Exception ex) {
        return ErrorResponse.builder()
                .message("An unexpected error occurred: " + ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }
}
