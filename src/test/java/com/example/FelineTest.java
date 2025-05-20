package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    private Feline felineMock;

    @Test
    public void testEatMeat() throws Exception {
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Feline feline = new Feline();
        List<String> actualEatMeat = feline.eatMeat();
        Assert.assertEquals(felineMock.eatMeat(), actualEatMeat);
    }

    @Test
    public void testGetFamily() throws Exception {
        Mockito.when(felineMock.getFamily()).thenReturn("Кошачьи");

        Feline feline = new Feline();
        String actualGetFamily = feline.getFamily();
        Assert.assertEquals(felineMock.getFamily(), actualGetFamily);
    }

    @Spy
    private Feline felineSpy;

    @Test
    public void testGetKittens() throws Exception {
        Mockito.when(felineSpy.getKittens(5)).thenReturn(5);
        Assert.assertEquals(5, felineSpy.getKittens(5));
    }

    @Test
    public void testGetKittensNoParams() throws Exception {
        Mockito.when(felineSpy.getKittens()).thenReturn(1);
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens();
        int actualResult = felineSpy.getKittens();
        Assert.assertEquals(1, actualResult);
    }


}
