package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ChipsTest {
   // A1|Potato Crisps|3.05|Chip

    Chips chips = new Chips("A1", "Potato Crisps", 3.05);
    @Test
    public void getSound() {
        VendingItem chips = new Chips("A1", "Potato Crisps", 3.05);

        String actual = chips.getSound();

        String expected = "Crunch Crunch, Yum!";

        Assert.assertEquals(expected, actual);

    }

    //Arrange

    //Act

    //Assert


}