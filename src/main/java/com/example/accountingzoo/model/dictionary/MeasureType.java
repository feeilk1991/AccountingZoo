package com.example.accountingzoo.model.dictionary;

public enum MeasureType {
    KG("килограмм"),
    PCS("шт"),
    L("л");

    final String name;

    MeasureType(String name) {
        this.name = name;
    }
}
