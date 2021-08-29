package com.techelevator;

import java.math.BigDecimal;

public class Chips extends VendingItem {

    public Chips(String slotLocation, String productName, double price) {
        super(slotLocation, productName, new BigDecimal(price), 5);
        super.setSound("Crunch Crunch, Yum!");
    }

}
