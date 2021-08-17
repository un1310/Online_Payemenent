package com.moneytap.CustomerWallet.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JwtResponse {
    @Id
    private String jwtToken;

    public JwtResponse() {
    }

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
