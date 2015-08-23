package com.ps.tutorial.jpa.dao;

import com.ps.tutorial.jpa.model.SettingsEntry;

public interface SettingsDao {

    public SettingsEntry getEntry(String name);

    public SettingsEntry getEntryWithCriteria(String name);

    public void createEntry(SettingsEntry entry);

    public void updateEntry(SettingsEntry entry);

    public void deleteEntry(String name);

}
