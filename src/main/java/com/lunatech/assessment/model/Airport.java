package com.lunatech.assessment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by User on 05/27/2017.
 */
@Entity
@Table(name = "airport")
public class Airport {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "ident")
    private String ident;
    @Column(name = "type")
    private String type;
    @Column(name = "name")
    private String name;
    @Column(name = "latitude_deg")
    private Float latitude_deg;
    @Column(name = "longitude_deg")
    private Float longitude_deg;
    @Column(name = "elevation_ft")
    private Integer elevation_ft;
    @Column(name = "iso_region")
    private String iso_region;
    @Column(name = "municipality")
    private String municipality;
    @Column(name = "scheduled_service")
    private String scheduled_service;
    @Column(name = "gps_code")
    private String gps_code;
    @Column(name = "iata_code")
    private String iata_code;
    @Column(name = "local_code")
    private String local_code;
    @Column(name = "home_link")
    private String home_link;
    @Column(name = "wikipedia_link")
    private String wikipedia_link;
    @Column(name = "keywords")
    private String keywords;

    @ManyToOne
    @JoinColumn(name = "country_ref", insertable=false, updatable = false)
    @JsonIgnore
    private Country country;

    @OneToMany(mappedBy = "airport")
    private List<RunWay> runways;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getLatitude_deg() {
        return latitude_deg;
    }

    public void setLatitude_deg(Float latitude_deg) {
        this.latitude_deg = latitude_deg;
    }

    public Float getLongitude_deg() {
        return longitude_deg;
    }

    public void setLongitude_deg(Float longitude_deg) {
        this.longitude_deg = longitude_deg;
    }

    public Integer getElevation_ft() {
        return elevation_ft;
    }

    public void setElevation_ft(Integer elevation_ft) {
        this.elevation_ft = elevation_ft;
    }

    public String getIso_region() {
        return iso_region;
    }

    public void setIso_region(String iso_region) {
        this.iso_region = iso_region;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getScheduled_service() {
        return scheduled_service;
    }

    public void setScheduled_service(String scheduled_service) {
        this.scheduled_service = scheduled_service;
    }

    public String getGps_code() {
        return gps_code;
    }

    public void setGps_code(String gps_code) {
        this.gps_code = gps_code;
    }

    public String getIata_code() {
        return iata_code;
    }

    public void setIata_code(String iata_code) {
        this.iata_code = iata_code;
    }

    public String getLocal_code() {
        return local_code;
    }

    public void setLocal_code(String local_code) {
        this.local_code = local_code;
    }

    public String getHome_link() {
        return home_link;
    }

    public void setHome_link(String home_link) {
        this.home_link = home_link;
    }

    public String getWikipedia_link() {
        return wikipedia_link;
    }

    public void setWikipedia_link(String wikipedia_link) {
        this.wikipedia_link = wikipedia_link;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<RunWay> getRunways() {
        return runways;
    }

    public void setRunways(List<RunWay> runways) {
        this.runways = runways;
    }
}
