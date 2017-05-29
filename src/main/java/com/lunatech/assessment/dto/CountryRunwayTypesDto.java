package com.lunatech.assessment.dto;

import com.lunatech.assessment.model.Country;

import java.util.List;

/**
 * Created by User on 05/28/2017.
 */
public class CountryRunwayTypesDto {
    private Country country;
    private List<String> runwayType;

    public CountryRunwayTypesDto(Country country, List<String> runwayType) {
        this.country = country;
        this.runwayType = runwayType;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<String> getRunwayType() {
        return runwayType;
    }

    public void setRunwayType(List<String> runwayType) {
        this.runwayType = runwayType;
    }
}
