package com.guru.mysqlshowcase.DTO.LoginDTO;

public class Bean {
    String email;
    String password;
    Boolean isValid;
    Boolean isAdmin;

    public Boolean getAdmin() {
        return isAdmin;
    }
    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
    public Boolean getValid() {
        return isValid;
    }
    public void setValid(Boolean valid) {
        isValid = valid;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
