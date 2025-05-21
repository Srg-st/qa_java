package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    // Вместо мока используется шпион для класса Feline
    @Spy
    private Feline felineSpy = new Feline();

    @Test
    public void testEatMeat() throws Exception {
        Mockito.when(felineSpy.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualEatMeat = felineSpy.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), actualEatMeat);
    }

    @Test
    public void testGetFamily() throws Exception {
        Mockito.when(felineSpy.getFamily()).thenReturn("Кошачьи");
        Feline feline = new Feline();
        String actualGetFamily = feline.getFamily();
        Assert.assertEquals(felineSpy.getFamily(), actualGetFamily);
    }


    @Test
    public void testGetKittens() throws Exception {
        Mockito.when(felineSpy.getKittens(5)).thenReturn(5);
        Assert.assertEquals(5, felineSpy.getKittens(5));
    }

    @Test
    public void testGetKittensNoParams() throws Exception {
        Mockito.when(felineSpy.getKittens()).thenReturn(1);
        int actualResult = felineSpy.getKittens();
        Assert.assertEquals(1, actualResult);
    }
    //Выделил отдельно тест для проверки количества вызовов метода getKittens()
    @Test
    public void testGetKittensNoParamsNumberInvoc() throws Exception {
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens();
    }


}
