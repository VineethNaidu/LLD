package org.example.lld.casestudies.parkinglot.repository;

import org.example.lld.casestudies.parkinglot.model.Token;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class TokenRepository {
    private Map<Long, Token> tokens = new TreeMap<>();
    private int previousId = 0;
    public Token saveToken(Token token){
        previousId += 1;
        token.setId( previousId);
        tokens.put((long) previousId , token);
        return token;
    }
}
