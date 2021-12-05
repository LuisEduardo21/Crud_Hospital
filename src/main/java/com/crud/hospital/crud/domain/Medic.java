package com.crud.hospital.crud.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;

public class Medic implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private ObjectId _id;
    private String CPF;
    private String name;
    private String password;

    public Medic(){

    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Medic(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
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

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medic medic = (Medic) o;
        return Objects.equals(name, medic.name) && Objects.equals(password, medic.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}
