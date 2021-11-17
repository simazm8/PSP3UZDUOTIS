package com.simo.psp3.controllers;

public class Country {

    int numberLength;
    String numberPrefix;
    char numberAfterPrefix;

    public Country(int numberLength, String numberPrefix, char numberAfterPrefix)
    {
        this.numberLength = numberLength;
        this.numberPrefix = numberPrefix;
        this.numberAfterPrefix = numberAfterPrefix;
    }

    public void setNumberLength(int numberLength) {
        this.numberLength = numberLength;
    }

    public int getNumberLength() {
        return numberLength;
    }

    public void setNumberPrefix(String numberPrefix) {
        this.numberPrefix = numberPrefix;
    }

    public String getNumberPrefix() {
        return numberPrefix;
    }

    public void setNumberAfterPrefix(char numberAfterPrefix) {
        this.numberAfterPrefix = numberAfterPrefix;
    }

    public char getNumberAfterPrefix() {
        return numberAfterPrefix;
    }
}
