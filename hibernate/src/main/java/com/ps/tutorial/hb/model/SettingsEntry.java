package com.ps.tutorial.hb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "settings")
public class SettingsEntry {

    private String name;
    private String value;

    public SettingsEntry() {}

    public SettingsEntry(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Id @Column(name = "name", unique = true, nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SettingsEntry entry = (SettingsEntry) o;
        return name.equals(entry.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "SettingsEntry{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

}
