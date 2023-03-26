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

   //Constructors
    public User() {}
    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);

    }

    //Getters and Setters

    public String getUsername() {
        return username;
    }

    //Instance Methods
    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

}
