package com.techelevator;

import java.math.BigDecimal;

public class Candy extends VendingItem {

    public Candy(String slotLocation, String productName, double price) {
        super(slotLocation, productName, new BigDecimal(price), 5);
        super.setSound("Munch Munch, Yum!");
    }
}
