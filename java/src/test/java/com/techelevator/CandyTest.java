package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CandyTest {

    @Test
    public void getSound() {
      //  B1|Moonpie|1.80|Candy
        VendingItem candy = new Candy("B1", "Moonpie", 1.80);

        String actual = candy.getSound();

        String expected = "Munch Munch, Yum!";

        Assert.assertEquals(expected, actual);

    }
}