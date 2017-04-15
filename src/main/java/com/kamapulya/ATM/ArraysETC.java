package com.kamapulya.ATM;

import java.util.ArrayList;
import java.util.Arrays;

class ArraysETC {

    private ArrayList<Integer> cash = new ArrayList<>(); //I think I should replace arrayList with Set or some other thing soon
    private String currency;


    void makeArray() { //In the future I can set up array depending on the country in an arguments
        cash.addAll(Arrays.asList(100, 50, 20, 10, 5, 2, 1)); //adds banknotes in the array
        currency = "dollars";
    }

    ArrayList<Integer> getCash() {
        return cash;
    }

    String getCurrency() {
        return currency;
    }
}