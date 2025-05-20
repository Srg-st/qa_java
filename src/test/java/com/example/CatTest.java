package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline felineMock;

    @Test
    public void testCatGetSound() {
        Cat cat = new Cat (felineMock);

        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testCatGetFood() throws Exception {
        Cat cat = new Cat (felineMock);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Хищник"));

        Assert.assertEquals(List.of("Хищник"), cat.getFood());

        Mockito.verify(felineMock, Mockito.times(1)).eatMeat();

    }
}
