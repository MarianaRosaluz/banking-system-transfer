package br.rosaluz.banking.system.transfer.handler;

import br.rosaluz.banking.system.transfer.exception.BankingSystemAuthenticationException;
import br.rosaluz.banking.system.transfer.handler.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({BankingSystemAuthenticationException.class})
    public ResponseEntity<?> handleBankingSystemAuthenticationException(final BankingSystemAuthenticationException bankingSystemAuthenticationException) {
        return ResponseEntity.status(bankingSystemAuthenticationException.getStatus()).body(
                ErrorResponse.builder()
                        .codeStatus(bankingSystemAuthenticationException.getStatus().value())
                        .field(bankingSystemAuthenticationException.getFieldError())
                        .description(bankingSystemAuthenticationException.getMessage())
                        .build()
        );
    }

}
