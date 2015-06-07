package com.ps.tutorial.hb.dao;

import com.ps.tutorial.hb.model.Country;

import java.util.List;

public interface CountryDao {

    public Country getCountry(int id);

    public Country getCountry(String name);

    public List<Country> getCountries();

    public void createCountry(Country country);

    public void updateCountry(Country country);

    public void deleteCountry(int id);

    public void deleteCountry(String name);

}
