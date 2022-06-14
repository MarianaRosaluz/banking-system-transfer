package br.rosaluz.banking.system.transfer.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BankingSystemAuthenticationException  extends RuntimeException {

    private final String fieldError;
    private final HttpStatus status;

    public BankingSystemAuthenticationException(final String message, String fieldError, HttpStatus status) {
        super(message);
        this.fieldError = fieldError;
        this.status = status;
    }
}
