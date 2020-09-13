package com.drAppointments.Final.Project.model.dao;

import javax.persistence.Entity;

@Entity
public class Doctor extends UserDao {

    private int pesel;
    private String gender;
    private String city;
    private String medicacilSpecialization;
    private int phone;
    private String email;

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMedicacilSpecialization() {
        return medicacilSpecialization;
    }

    public void setMedicacilSpecialization(String medicacilSpecialization) {
        this.medicacilSpecialization = medicacilSpecialization;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
