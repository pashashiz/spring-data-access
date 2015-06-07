package com.ps.tutorial.hb.dao;

import com.ps.tutorial.hb.DataConfig;
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

    }

    @Test
    public void testGetCountryByName() throws Exception {

    }

    @Test
    public void testGetCountries() throws Exception {

    }

    @Test
    public void testCreateEntry() throws Exception {

    }

    @Test
    public void testUpdateEntry() throws Exception {

    }

    @Test
    public void testDeleteEntry() throws Exception {

    }

    @Test
    public void testDeleteEntry1() throws Exception {

    }
}