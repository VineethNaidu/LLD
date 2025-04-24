package org.example.lld.casestudies.parkinglot.controller;

import org.example.lld.casestudies.parkinglot.dtos.IssueTokenRequestDTO;
import org.example.lld.casestudies.parkinglot.dtos.IssueTokenResponseDTO;
import org.example.lld.casestudies.parkinglot.dtos.ResponseStatus;
import org.example.lld.casestudies.parkinglot.model.Token;
import org.example.lld.casestudies.parkinglot.service.TokenService;

public class TokenController {
    private TokenService tokenService;

    // Dependency Injection
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public IssueTokenResponseDTO issueToken(IssueTokenRequestDTO issueTokenRequestDTO) {
        IssueTokenResponseDTO issueTokenResponseDTO = new IssueTokenResponseDTO();
        try {
            Token token = tokenService.issueToken(
                    issueTokenRequestDTO.getVehicleNumber(),
                    issueTokenRequestDTO.getVehicleType(),
                    issueTokenRequestDTO.getVehicleOwnerName(),
                    issueTokenRequestDTO.getOwnerContactNumber(),
                    issueTokenRequestDTO.getGateNumber()
            );
            issueTokenResponseDTO.setToken(token);
            issueTokenResponseDTO.setStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e) {
            issueTokenResponseDTO.setStatus(ResponseStatus.FAILURE);
            issueTokenResponseDTO.setFailureMessage("Unable to issue token");
        }
        return issueTokenResponseDTO;
    }
}

// TODO
// 1. Need to interact with the client
// 2. When request comes, Validations can happen in controller
// 3. It needs to call the service and send the parameters
// 4. receive the output and accordingly create your response
