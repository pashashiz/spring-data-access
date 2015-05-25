package com.ps.tutorial.jpa.dao;

import com.ps.tutorial.jpa.model.SettingsEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

@Repository
public class SettingsDaoImpl implements SettingsDao {

    @PersistenceContext
    EntityManager manager;

    @Override
    public SettingsEntry getEntry(String name) {
        return manager.find(SettingsEntry.class, name);
    }

    @Override
    public void createEntry(SettingsEntry entry) {
        manager.persist(entry);
    }

    @Override
    public void updateEntry(SettingsEntry entry) {
        manager.merge(entry);
    }

    @Override
    public void deleteEntry(String name) {
        manager.remove(getEntry(name));
    }

}
