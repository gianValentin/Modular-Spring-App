package pe.giancarlo.model.doctor;

import java.util.Random;

public class Doctor {
    private int id;
    private String name;
    private String lastName;
    private String speciality;

    public Doctor(int id, String name, String lastName, String speciality) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
