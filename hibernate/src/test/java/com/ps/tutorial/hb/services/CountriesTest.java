package com.ps.tutorial.hb.services;

import com.ps.tutorial.hb.DataConfig;
import com.ps.tutorial.hb.model.Country;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataConfig.class})
@Transactional
@SqlConfig()
public class CountriesTest {

    @Autowired
    private Countries countries;

    @Test
    public void testCrud(){
        List<Country> list = countries.getCountries();
        System.out.println(list);
    }

}
