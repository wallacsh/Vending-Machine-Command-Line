package com.techelevator;

import java.math.BigDecimal;

public class Drink extends VendingItem {

    public Drink(String slotLocation, String productName, double price) {
        super(slotLocation, productName, new BigDecimal(price), 5);
        super.setSound("Glug Glug, Yum!");
    }
}
