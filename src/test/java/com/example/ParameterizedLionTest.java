package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class ParameterizedLionTest {
    private String sex;
    private boolean expectedHasMane;

    public ParameterizedLionTest(String sex, boolean expectedHasMane){
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getSexAndExpectedHasMane(){
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }
    @Test
    public void testHasMane() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Lion lion = new Lion(sex, felineMock);
        boolean hasMane = lion.doesHaveMane();
        Assert.assertEquals(expectedHasMane, hasMane);
    }

}

