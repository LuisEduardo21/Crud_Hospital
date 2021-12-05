package com.crud.hospital.crud.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;

public class Nurse implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private ObjectId _id;
    private String name;
    private String password;
    private String CPF;

    public Nurse(){

    }

    public Nurse(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nurse nurse = (Nurse) o;
        return Objects.equals(name, nurse.name) && Objects.equals(password, nurse.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}
