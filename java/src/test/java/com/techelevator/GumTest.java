package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GumTest {
    //D1|U-Chews|0.85|Gum
    @Test
    public void getSound() {
        VendingItem gum = new Gum("D1", "U-Chews", 0.85);

        String actual = gum.getSound();

        String expected = "Chew Chew, Yum!";

        Assert.assertEquals(expected, actual);

    }

}