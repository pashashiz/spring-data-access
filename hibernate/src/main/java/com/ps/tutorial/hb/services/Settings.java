package com.ps.tutorial.hb.services;

import com.ps.tutorial.hb.dao.SettingsDao;
import com.ps.tutorial.hb.model.SettingsEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Settings {

    @Autowired private SettingsDao dao;

    @Transactional(readOnly = true)
    public SettingsEntry getEntry(String name) {
        return dao.getEntry(name);
    }

    @Transactional
    public void createEntry(SettingsEntry entry) {
        dao.createEntry(entry);
    }

    @Transactional
    public void updateEntry(SettingsEntry entry) {
        dao.updateEntry(entry);
    }

    @Transactional
    public void deleteEntry(String name) {
        dao.deleteEntry(name);
    }

}
