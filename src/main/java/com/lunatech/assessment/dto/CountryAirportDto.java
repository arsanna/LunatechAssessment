package com.lunatech.assessment.dto;

import com.lunatech.assessment.model.Country;

/**
 * Created by User on 05/28/2017.
 */
public class CountryAirportDto {
    private Country country;
    private long count;

    public CountryAirportDto(Country country, long count) {
        this.country = country;
        this.count = count;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
