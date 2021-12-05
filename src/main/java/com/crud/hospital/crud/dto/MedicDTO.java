package com.crud.hospital.crud.dto;

import com.crud.hospital.crud.domain.Medic;
import com.mongodb.lang.NonNull;

import java.io.Serializable;

public class MedicDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    @NonNull
    private String name;

    @NonNull
    private String CPF;

    public MedicDTO(Medic obj){
        this.CPF = obj.getCPF();
        this.name = obj.getName();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getCPF() {
        return CPF;
    }

    public void setCPF(@NonNull String CPF) {
        this.CPF = CPF;
    }
}
