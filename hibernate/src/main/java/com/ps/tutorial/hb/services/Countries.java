package com.ps.tutorial.hb.services;

import com.ps.tutorial.hb.dao.CountryDao;
import com.ps.tutorial.hb.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Countries {

    @Autowired private CountryDao dao;

    @Transactional(readOnly = true)
    public Country getCountry(int id) {
        return dao.getCountry(id);
    }

    @Transactional(readOnly = true)
    public Country getCountry(String name) {
        return dao.getCountry(name);
    }

    @Transactional(readOnly = true)
    public List<Country> getCountries() {
        return dao.getCountries();
    }


}
