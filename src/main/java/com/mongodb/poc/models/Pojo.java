package com.mongodb.poc.models;

import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

public class Pojo {
    private ObjectId id;

    private List<Transaction> transactions;

    private Map<String, ExtendedProperty> properties;

    public Map<String, ExtendedProperty> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, ExtendedProperty> properties) {
        this.properties = properties;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "id=" + id +
                ", transactions=" + transactions +
                ", properties=" + properties +
                '}';
    }
}
