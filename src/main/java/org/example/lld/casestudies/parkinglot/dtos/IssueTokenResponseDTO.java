package org.example.lld.casestudies.parkinglot.dtos;

import org.example.lld.casestudies.parkinglot.model.Token;

public class IssueTokenResponseDTO {
    private Token token;
    private ResponseStatus status;
    private String failureMessage;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }
}
