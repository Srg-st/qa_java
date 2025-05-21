package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private Cat cat;

    @Mock
    Feline felineMock;

    @Before
    public void initCat(){
        cat = new Cat (felineMock);
    }

    @Test
    public void testCatGetSound() {
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testCatGetFood() throws Exception {
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Хищник"));
        Assert.assertEquals(List.of("Хищник"), cat.getFood());
    }
    //Выделил отдельно тест на проверку количества вызовов метода eatMeat()
    @Test
    public void testCatGetFoodNumberInvoc() throws Exception {
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Хищник"));
        cat.getFood();
        Mockito.verify(felineMock, Mockito.times(1)).eatMeat();
    }
}
