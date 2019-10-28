package com.mongodb.poc.models;

import java.math.BigDecimal;

public class Transaction {
    private String label;
    private BigDecimal value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Transaction{" +
                "label='" + label + '\'' +
                ", value=%.3f}", value);
    }
}
