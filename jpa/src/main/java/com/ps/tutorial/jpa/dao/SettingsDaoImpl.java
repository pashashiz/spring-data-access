package com.ps.tutorial.jpa.dao;

import com.ps.tutorial.jpa.model.SettingsEntry;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

@Repository
public class SettingsDaoImpl implements SettingsDao {

    @PersistenceContext
    EntityManager manager;

    @Override
    public SettingsEntry getEntry(String name) {
        return manager.find(SettingsEntry.class, name);
    }

    @Override
    public SettingsEntry getEntryWithCriteria(String name) {
        // Create criteria
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<SettingsEntry> criteria = builder.createQuery(SettingsEntry.class);
        Root<SettingsEntry> root = criteria.from(SettingsEntry.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("name"), name));
        // Execute criteria
        return manager.createQuery(criteria).getSingleResult();
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
