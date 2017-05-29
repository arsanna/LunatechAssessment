package com.lunatech.assessment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by User on 05/27/2017.
 */
@Entity
@Table(name = "runway")
public class RunWay {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "length_ft")
    private Integer length_ft;
    @Column(name = "width_ft")
    private Integer width_ft;
    @Column(name = "surface")
    private String surface;
    @Column(name = "lighted")
    private Integer lighted;
    @Column(name = "closed")
    private Integer closed;
    @Column(name = "le_ident")
    private String le_ident;
    @Column(name = "le_latitude_deg")
    private String le_latitude_deg;
    @Column(name = "le_longitude_deg")
    private String le_longitude_deg;
    @Column(name = "le_elevation_ft")
    private String le_elevation_ft;
    @Column(name = "le_heading_degT")
    private String le_heading_degT;
    @Column(name = "le_displaced_threshold_ft")
    private String le_displaced_threshold_ft;
    @Column(name = "he_ident")
    private String he_ident;
    @Column(name = "he_latitude_deg")
    private String he_latitude_deg;
    @Column(name = "he_longitude_deg")
    private String he_longitude_deg;
    @Column(name = "he_elevation_ft")
    private String he_elevation_ft;
    @Column(name = "he_heading_degT")
    private String he_heading_degT;
    @Column(name = "he_displaced_threshold_ft")
    private String he_displaced_threshold_ft;

    @ManyToOne
    @JoinColumn(name = "airport_ref", insertable=false, updatable = false)
    @JsonIgnore
    private Airport airport;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getLength_ft() {
        return length_ft;
    }

    public void setLength_ft(Integer length_ft) {
        this.length_ft = length_ft;
    }

    public Integer getWidth_ft() {
        return width_ft;
    }

    public void setWidth_ft(Integer width_ft) {
        this.width_ft = width_ft;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public Integer getLighted() {
        return lighted;
    }

    public void setLighted(Integer lighted) {
        this.lighted = lighted;
    }

    public Integer getClosed() {
        return closed;
    }

    public void setClosed(Integer closed) {
        this.closed = closed;
    }

    public String getLe_ident() {
        return le_ident;
    }

    public void setLe_ident(String le_ident) {
        this.le_ident = le_ident;
    }

    public String getLe_latitude_deg() {
        return le_latitude_deg;
    }

    public void setLe_latitude_deg(String le_latitude_deg) {
        this.le_latitude_deg = le_latitude_deg;
    }

    public String getLe_longitude_deg() {
        return le_longitude_deg;
    }

    public void setLe_longitude_deg(String le_longitude_deg) {
        this.le_longitude_deg = le_longitude_deg;
    }

    public String getLe_elevation_ft() {
        return le_elevation_ft;
    }

    public void setLe_elevation_ft(String le_elevation_ft) {
        this.le_elevation_ft = le_elevation_ft;
    }

    public String getLe_heading_degT() {
        return le_heading_degT;
    }

    public void setLe_heading_degT(String le_heading_degT) {
        this.le_heading_degT = le_heading_degT;
    }

    public String getLe_displaced_threshold_ft() {
        return le_displaced_threshold_ft;
    }

    public void setLe_displaced_threshold_ft(String le_displaced_threshold_ft) {
        this.le_displaced_threshold_ft = le_displaced_threshold_ft;
    }

    public String getHe_ident() {
        return he_ident;
    }

    public void setHe_ident(String he_ident) {
        this.he_ident = he_ident;
    }

    public String getHe_latitude_deg() {
        return he_latitude_deg;
    }

    public void setHe_latitude_deg(String he_latitude_deg) {
        this.he_latitude_deg = he_latitude_deg;
    }

    public String getHe_longitude_deg() {
        return he_longitude_deg;
    }

    public void setHe_longitude_deg(String he_longitude_deg) {
        this.he_longitude_deg = he_longitude_deg;
    }

    public String getHe_elevation_ft() {
        return he_elevation_ft;
    }

    public void setHe_elevation_ft(String he_elevation_ft) {
        this.he_elevation_ft = he_elevation_ft;
    }

    public String getHe_heading_degT() {
        return he_heading_degT;
    }

    public void setHe_heading_degT(String he_heading_degT) {
        this.he_heading_degT = he_heading_degT;
    }

    public String getHe_displaced_threshold_ft() {
        return he_displaced_threshold_ft;
    }

    public void setHe_displaced_threshold_ft(String he_displaced_threshold_ft) {
        this.he_displaced_threshold_ft = he_displaced_threshold_ft;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
