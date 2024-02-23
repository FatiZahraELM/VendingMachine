package org.example;

public enum Product {
    WATER("water", 5),
    COCA("coca", 7),
    TWIX("twix", 10),
    BUENO("bueno", 12);


    private final String name;
    private final double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }



}