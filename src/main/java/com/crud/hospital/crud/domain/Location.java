package com.crud.hospital.crud.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJson;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import java.io.Serializable;
import java.util.Objects;

public class Location implements Serializable {
    private static final long serialVersionUID = 19L;

    @Id
    private String id;
    private String name;
    private String referenceId;

    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
    private GeoJsonPoint position;

    public Location(){

    }

    public Location(String referenceId, String name, GeoJsonPoint position) {
        this.referenceId = referenceId;
        this.name = name;
        this.position = position;
    }

    public Location(String name, GeoJsonPoint position) {
        this.name = name;
        this.position = position;
    }

    public Location(String referenceId, String name, double longitude, double latitude) {
        GeoJsonPoint position = new GeoJsonPoint(latitude, longitude);

        this.referenceId = referenceId;
        this.name = name;
        this.position = position;
    }

    public Location(String subject, double longitude, double latitude) {
        GeoJsonPoint position = new GeoJsonPoint(latitude, longitude);

        this.name = subject;
        this.position = position;
    }

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeoJsonPoint getLocation() {
        return this.position;
    }

    public void setLocation(final GeoJsonPoint position) {
        this.position = position;
    }

    public GeoJsonPoint getPosition() {
        return position;
    }

    public void setPosition(GeoJsonPoint position) {
        this.position = position;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final Location that = (Location) o;
        return 	Objects.equals(this.getId(), that.getId()) &&
                Objects.equals(this.getName(), that.getName()) &&
                Objects.equals(this.getReferenceId(), that.getReferenceId()) &&
                Objects.equals(this.getPosition(), that.getPosition());

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getReferenceId(), this.getName(), this.getPosition());
    }

}
