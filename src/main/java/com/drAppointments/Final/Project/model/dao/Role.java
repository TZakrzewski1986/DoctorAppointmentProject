package com.drAppointments.Final.Project.model.dao;

import javax.persistence.*;

@Table(name = "roles")
public enum Role {


    PATIENT("ROLE_PATIENT"),
    DOCTOR("ROLE_DOCTOR"),
    ADMIN("ROLE_ADMIN");

    private String userRole;

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    private final String displayValue;

    Role(String displayValue) {
        this.displayValue = displayValue;
    }

    public String  getDisplayValue() {
        return displayValue;
    }
}
