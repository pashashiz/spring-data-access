package com.ps.tutorial.hb.dao;

import com.ps.tutorial.hb.model.Country;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;
import java.util.Set;

@Repository
public class CountryDaoImpl implements CountryDao {

    @Autowired
    SessionFactory factory;

    @Override
    public Country getCountry(int id) {
        return (Country) factory.getCurrentSession().get(Country.class, id);
    }

    @Override
    public Country getCountry(String name) {
        return (Country) factory.getCurrentSession()
                .getNamedQuery("country.get-by-name").setString("name", name).uniqueResult();
    }

    @Override @SuppressWarnings("unchecked")
    public List<Country> getCountries() {
        return (List<Country>)factory.getCurrentSession()
                .getNamedQuery("country.get-all").list();
    }

    @Override
    public void createCountry(Country country) {
        factory.getCurrentSession().save(country);
    }

    @Override
    public void updateCountry(Country country) {
        factory.getCurrentSession().update(country);
    }

    @Override
    public void deleteCountry(int id) {
        Country country = getCountry(id);
        if (country != null)
            factory.getCurrentSession().delete(country);
    }

    @Override
    public void deleteCountry(String name) {
        Country country = getCountry(name);
        if (country != null)
            factory.getCurrentSession().delete(country);
    }

}
