package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {
    private Feline feline = new Feline();


    @Test
    public void testEatMeat() throws Exception {
        List<String> actualEatMeat = feline.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), actualEatMeat);
    }

    @Test
    public void testGetFamily() throws Exception {
        String expectedGetFamily = "Кошачьи";
        String actualGetFamily = feline.getFamily();
        Assert.assertEquals(expectedGetFamily, actualGetFamily);
    }


    @Test
    public void testGetKittens() throws Exception {
        int expectedCount = 5;
        int actualCount = feline.getKittens(expectedCount);
        Assert.assertEquals(expectedCount, actualCount);

    }

    @Test
    public void testGetKittensNoParams() throws Exception {
        int expectedCount = 1;
        int actualCount = feline.getKittens();
        Assert.assertEquals(expectedCount, actualCount);
    }

}
