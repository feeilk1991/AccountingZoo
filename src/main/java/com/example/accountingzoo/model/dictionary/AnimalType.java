package com.example.accountingzoo.model.dictionary;

import javax.persistence.Enumerated;

public enum AnimalType {
    MAMMAL("млекопитающее"),
    BIRD("птица");

    private final String name;

    AnimalType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
