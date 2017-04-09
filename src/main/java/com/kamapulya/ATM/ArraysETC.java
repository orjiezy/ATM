package com.kamapulya.ATM;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysETC {

    private ArrayList<Integer> cash = new ArrayList<>(); //I think I should replace arrayList with Set or some other thing soon
    private String currency;


    public void makeArray() { //In the future I can set up array depending on the country in an arguments
        cash.addAll(Arrays.asList(5000, 1000, 500, 100, 50, 10)); //adds banknotes in the array
        currency = "rubles";
    }

    public ArrayList<Integer> getCash() {
        return cash;
    }

    public String getCurrency() {
        return currency;
    }
}