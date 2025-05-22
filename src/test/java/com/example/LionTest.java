package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline felineMock;

    @Test
    public void testGetKitten () throws Exception {
        Mockito.when(felineMock.getKittens()).thenReturn(1);

        Lion lion = new Lion("Самка", felineMock);

        Assert.assertEquals(1, lion.getKittens());
    }



    @Test
    public void testGetFood () throws Exception {
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самка", felineMock);

        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void testUncorrectSex() throws Exception {
        try {
            Lion lion = new Lion("Неверный пол", felineMock);
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }

}
