package com.ps.tutorial.hb.dao;

import com.ps.tutorial.hb.DataConfig;
import com.ps.tutorial.hb.model.Country;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataConfig.class})
@Transactional
public class CountryDaoTest {

    @Autowired CountryDao dao;

    @Test
    public void testGetCountry() throws Exception {
        assertEquals(dao.getCountry(1).getName(), "Afghanistan");
    }

    @Test
    public void testGetCountryByName() throws Exception {
        assertEquals(dao.getCountry("Afghanistan").getId(), 1);
    }

    @Test
    public void testGetCountries() throws Exception {
        assertTrue(dao.getCountries().size() > 1);
    }

    @Test @Rollback
    public void testCreateCountry() throws Exception {
        Country country = new Country();
        country.setName("TestCountry");
        dao.createCountry(country);
        assertTrue(country.getId() > 0);
    }

    @Test @Rollback
    public void testUpdateCountry() throws Exception {
        Country country = dao.getCountry(1);
        country.setName("TestAfghanistan");
        dao.updateCountry(country);
        assertEquals(dao.getCountry(1).getName(), "TestAfghanistan");
    }

    @Test @Rollback @Ignore
    public void testDeleteCountry() throws Exception {
        dao.deleteCountry(1);
        assertNull(dao.getCountry(1));
    }

    @Test @Rollback @Ignore
    public void testDeleteCountryByName() throws Exception {
        dao.deleteCountry("Afghanistan");
        assertNull(dao.getCountry("Afghanistan"));
    }

}