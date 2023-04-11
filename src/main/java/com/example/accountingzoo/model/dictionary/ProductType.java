package com.example.accountingzoo.model.dictionary;

public enum ProductType {
    VEGETABLE("овощ"),
    FRUIT("фрукт"),
    WATER("жидкость"),
    MEAT("мясо");

    final String name;

    ProductType(String name) {
        this.name = name;
    }
}
