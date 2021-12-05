package com.crud.hospital.crud.domain;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Patients implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String cpf;
    private Date birthDate;
    private String gender;
    private double weight;
    private double height;
    private String UF;

    private Location location;

    public Patients(){

    }

    public Patients(String name, String cpf,String UF) {
        this.name = name;
        this.cpf = cpf;
        this.UF= UF;
    }

    public Patients(String id, String name, String cpf, Date birthDate, String gender, double weight, double height, String UF) {
        super();
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.gender = gender;
        this.weight= weight;
        this.height = height;
        this.UF = UF;

    }
    public Patients(String id, String name, String cpf, Date birthDate, String gender, String UF, double weight, double height, Location location) {
        super();
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.gender = gender;
        this.UF = UF;
        this.height= height;
        this.weight = weight;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cpf, birthDate, gender, weight, height, UF, location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patients patients = (Patients) o;
        return Double.compare(patients.weight, weight) == 0 && Double.compare(patients.height, height) == 0 && Objects.equals(name, patients.name) && Objects.equals(cpf, patients.cpf) && Objects.equals(birthDate, patients.birthDate) && Objects.equals(gender, patients.gender) && Objects.equals(UF, patients.UF) && Objects.equals(location, patients.location);
    }
}
