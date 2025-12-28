package com.examly.springapp.dto;

public class UserRequest {
    private String username;
    private String email;
    private String password;
    private String role;
    private String phoneNumber;
    private Long departmentId; // Matches JSON in your tests

    // Constructors
    public UserRequest() {}

    public UserRequest(String username, String email, String password, String role, String phoneNumber, Long departmentId) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.departmentId = departmentId;
    }

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Long getDepartmentId() { return departmentId; }
    public void setDepartmentId(Long departmentId) { this.departmentId = departmentId; }
}
