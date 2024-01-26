package org.launchcode.models;

import jakarta.validation.constraints.*;

public class User {
    @NotBlank
    @Size(min=5, max=15, message = "Username should be 5 to 15 characters long")
    private String username;
    @Email(message = "Email is incorrect")
    private String email;
    @NotBlank
    @Size(min = 6, message =" Password should be at least 6 characters long")
    private String password;
    @NotNull(message = "Passwords do not match!")
    private String verifyPassword;
    public User(){};

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {

        this.verifyPassword = verifyPassword;
        checkPassword();
    }


    public User(String username, String email, String password,String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword=verifyPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }
    private void checkPassword() {
        if (!(this.password == null) && !(this.verifyPassword == null)) {
            if (!(this.password.equals(this.verifyPassword))) {
                this.verifyPassword = null;
            }
        }
    }
}