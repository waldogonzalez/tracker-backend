package com.inendev.tracker.security.web.dto;

import javax.validation.constraints.NotBlank;

public class AuthenticationRequest {
    @NotBlank(message = "user is required")
    private String user;
    @NotBlank(message = "password is required")
    private String password;
    private Boolean rememberMe;

    public AuthenticationRequest(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
