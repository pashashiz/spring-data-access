package com.ps.tutorial.jpa.services;

import com.ps.tutorial.jpa.DataConfig;
import com.ps.tutorial.jpa.model.SettingsEntry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataConfig.class})
public class SettingsTest {

    @Autowired
    private Settings settings;

    @Test
    public void testCrud(){
        SettingsEntry entry = new SettingsEntry("key", "value");
        settings.createEntry(entry);
        assertEquals(settings.getEntry("key"), entry);
        assertEquals(settings.getEntryWithCriteria("key"), entry);
        entry.setValue("updated-value");
        settings.updateEntry(entry);
        assertEquals(settings.getEntry("key"), entry);
        settings.deleteEntry("key");
        assertNull(settings.getEntry("key"));
    }

}
