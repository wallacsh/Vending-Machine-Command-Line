package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

public class VendingItemTest {

    @Test
    public void getSlotLocation() {
        //A1|Potato Crisps|3.05|Chip
        VendingItem vendingItem = new VendingItem("A1", "Potato Crisps", new BigDecimal("3.05"), 5);

        String actual = vendingItem.getSlotLocation();

        String expected = "A1";

        Assert.assertEquals(expected, actual);



    }

    @Test
    public void getProductName() {

        VendingItem vendingItem = new VendingItem("A1", "Potato Crisps", new BigDecimal("3.05"), 5);

        String actual = vendingItem.getProductName();

        String expected = "Potato Crisps";

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getPrice() {
        VendingItem vendingItem = new VendingItem("A1", "Potato Crisps", new BigDecimal("3.05"), 5);

        BigDecimal actual = vendingItem.getPrice().setScale(2, RoundingMode.HALF_UP);

        BigDecimal expected = new BigDecimal(3.05).setScale(2, RoundingMode.HALF_UP);

        Assert.assertEquals(expected, actual);

    }


}