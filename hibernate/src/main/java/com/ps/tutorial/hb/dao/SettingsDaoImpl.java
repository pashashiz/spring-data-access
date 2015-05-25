package com.ps.tutorial.hb.dao;

import com.ps.tutorial.hb.model.SettingsEntry;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SettingsDaoImpl implements SettingsDao {

    @Autowired SessionFactory factory;

    @Override
    public SettingsEntry getEntry(String name) {
        return (SettingsEntry) factory.getCurrentSession().get(SettingsEntry.class, name);
    }

    @Override
    public void createEntry(SettingsEntry entry) {
        factory.getCurrentSession().save(entry);
    }

    @Override
    public void updateEntry(SettingsEntry entry) {
        factory.getCurrentSession().update(entry);
    }

    @Override
    public void deleteEntry(String name) {
        factory.getCurrentSession().delete(getEntry(name));
    }

}
