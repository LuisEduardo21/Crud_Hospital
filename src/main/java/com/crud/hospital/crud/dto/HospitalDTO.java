package com.crud.hospital.crud.dto;

import com.crud.hospital.crud.domain.Hospital;

import java.io.Serializable;

public class HospitalDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String address;
    private String longitude;
    private String latitude;

    public HospitalDTO(){

    }

    public HospitalDTO(Hospital obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.address = obj.getAddress();
        if(obj.getLocation() != null) {
            this.longitude = String.valueOf(obj.getLocation().getPosition().getX());
            this.latitude = String.valueOf(obj.getLocation().getPosition().getY());
        }
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
