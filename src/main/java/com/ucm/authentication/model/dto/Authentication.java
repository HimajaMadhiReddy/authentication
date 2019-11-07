package com.ucm.authentication.model.dto;

import java.util.UUID;

public class Authentication {

    private UUID resourceId;
    private String userName;
    private String password;
    private String role;
    private UUID personResourceId;

    public UUID getPersonResourceId() {
        return personResourceId;
    }

    public void setPersonResourceId(UUID personResourceId) {
        this.personResourceId = personResourceId;
    }

    public UUID getResourceId() {
        return resourceId;
    }

    public void setResourceId(UUID resourceId) {
        this.resourceId = resourceId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
