package com.lunatech.assessment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by User on 05/27/2017.
 */
@Entity
@Table(name = "country")
public class Country {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "code")
    String code;
    @Column(name = "name")
    private String name;
    @Column(name = "continent")
    private String continent;
    @Column(name = "wikipedia_link")
    private String wikipedia_link;
    @Column(name = "keywords")
    private String keywords;

    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<Airport> airports;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
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

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != country.id) return false;
        if (code != null ? !code.equals(country.code) : country.code != null) return false;
        if (name != null ? !name.equals(country.name) : country.name != null) return false;
        if (continent != null ? !continent.equals(country.continent) : country.continent != null) return false;
        if (wikipedia_link != null ? !wikipedia_link.equals(country.wikipedia_link) : country.wikipedia_link != null)
            return false;
        if (keywords != null ? !keywords.equals(country.keywords) : country.keywords != null) return false;
        return airports != null ? airports.equals(country.airports) : country.airports == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (continent != null ? continent.hashCode() : 0);
        result = 31 * result + (wikipedia_link != null ? wikipedia_link.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        result = 31 * result + (airports != null ? airports.hashCode() : 0);
        return result;
    }
}
