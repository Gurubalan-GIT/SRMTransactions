package com.guru.mysqlshowcase.DTO.RegisterDTO;

public class RegisterBean {
    String email;
    String password;
    String name;
    int age;
    String gender;
    int isValid;
    int isEmailExits;
    Boolean resultSetValid;

    public Boolean getResultSetValid() {
        return resultSetValid;
    }
    public void setResultSetValid(Boolean resultSetValid) {
        this.resultSetValid = resultSetValid;
    }
    public int isEmailExits() {
        return isEmailExits;
    }
    public void setEmailExits(int emailExits) {
        isEmailExits = emailExits;
    }
    public int getIsValid() {
        return isValid;
    }
    public void setIsValid(int isValid) {
        this.isValid = isValid;
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
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
}
