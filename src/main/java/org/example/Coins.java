package org.example;

public enum Coins {
    TEN(10),
    FIVE(5),
    TWO(2),
    ONE(1);

    public int getValue() {
        return value;
    }


    private final int value;

    Coins(int value) {
        this.value = value;
    }

}
