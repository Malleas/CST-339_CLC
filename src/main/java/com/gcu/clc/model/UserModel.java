package com.gcu.clc.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserModel {

    private int userId;

    @NotNull(message="First name is a required field")
    @Size(min=1, max=32, message="First name must be between 1 and 32 characters")
    private String firstName;

    @NotNull(message="Last name is a required field")
    @Size(min=1, max=32, message="Last name must be between 1 and 32 characters")
    private String lastName;

    @NotNull(message="Email is a required field")
    @Size(min=1, max=32, message="Email must be between 1 and 32 characters")
    private String email;

    @NotNull(message="Phone Number is required")
    @Size(min=1, max=10, message="Phone Number must be between 1 and 10 characters")
    private String phoneNumber;

    @NotNull(message="User name is a required field")
    @Size(min=1, max=32, message="User name must be between 1 and 32 characters")
    private String username;

    @NotNull(message="Password is a required field")
    @Size(min=1, max=32, message="Password must be between 1 and 32 characters")
    private String password;

    /**
     * non form entry fields, will be defaulted upon new user creation but getter/setter may be needed for future use to
     * limit site use or deactivate user.
     */
    private boolean isActive;
    private int roleId;

    public UserModel(String firstName, String lastName, String email, String phoneNumber, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }

    public UserModel(int userId, String firstName, String lastName, String email, String phoneNumber, String username, String password, boolean isActive, int roleId) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
        this.roleId = roleId;
    }

    public UserModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
