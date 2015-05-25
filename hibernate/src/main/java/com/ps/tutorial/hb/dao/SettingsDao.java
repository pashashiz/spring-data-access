package com.ps.tutorial.hb.dao;


import com.ps.tutorial.hb.model.SettingsEntry;

public interface SettingsDao {

    public SettingsEntry getEntry(String name);

    public void createEntry(SettingsEntry entry);

    public void updateEntry(SettingsEntry entry);

    public void deleteEntry(String name);

}
