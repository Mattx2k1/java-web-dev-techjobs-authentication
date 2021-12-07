package org.launchcode.javawebdevtechjobsauthentication.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity {

    @NotNull
    private String username;

    @NotNull
    private String pwHash;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public User() {}

    public User(String username, String password) {
        this.username = encoder.encode(username);
        this.pwHash = encoder.encode(password);
    }
    public boolean checkPassword(String password) {
        return encoder.matches(password, pwHash);
        }

    public String getUsername() {
        return username;
    }



}
