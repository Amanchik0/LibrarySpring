package io.back.libraryJava.payload.response;

import lombok.Getter;

@Getter
public class InvalidLoginResponse {

    private String email;
    private String password;

    public InvalidLoginResponse() {
        this.email = "Invalid Email";
        this.password = "Invalid Password";
    }
}
