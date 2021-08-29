package com.techelevator;

import java.math.BigDecimal;

public class Gum extends VendingItem{

    public Gum(String slotLocation, String productName, double price) {
        super(slotLocation, productName, new BigDecimal(price), 5);
        super.setSound("Chew Chew, Yum!");
    }
}
