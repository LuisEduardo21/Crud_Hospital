package com.crud.hospital.crud.dto;

import com.crud.hospital.crud.domain.Location;

import java.io.Serializable;
import java.util.Objects;

public class LocationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String referenceId;
    private String longitude;
    private String latitude;

    public LocationDTO(String name, String longitude, String latitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public LocationDTO(Location obj) {
        this.id = obj.getId();
        this.referenceId = obj.getReferenceId();
        this.name = obj.getName();
        this.latitude = String.valueOf(obj.getPosition().getY());
        this.longitude = String.valueOf(obj.getPosition().getX());
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

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationDTO that = (LocationDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(referenceId, that.referenceId) && Objects.equals(longitude, that.longitude) && Objects.equals(latitude, that.latitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, referenceId, longitude, latitude);
    }
}
