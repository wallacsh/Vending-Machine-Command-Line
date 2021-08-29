package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrinkTest {
    //C1|Cola|1.25|Drink
    @Test
    public void getSound() {
        VendingItem drink = new Drink("C1", "Cola", 1.25);

        String actual = drink.getSound();

        String expected = "Glug Glug, Yum!";

        Assert.assertEquals(expected, actual);

    }
}