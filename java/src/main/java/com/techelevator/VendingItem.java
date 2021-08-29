package com.techelevator;

import java.math.BigDecimal;

public class VendingItem {
    private String slotLocation;
    private String productName;
    private BigDecimal price;
    private int quantity = 5;
    private boolean soldOut = false;
    private String sound;

    public VendingItem(String slotLocation, String productName, BigDecimal price, int quantity) {
        this.slotLocation = slotLocation;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }


    public int getQuantity() {
        return quantity;
    }

    public String getSlotLocation() {
        return slotLocation;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void decQuantity() {
        quantity --;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
