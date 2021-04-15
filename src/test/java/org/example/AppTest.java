package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Before
    public void setUp() throws Exception {

        System.out.println("ben her testten önce koşarım.");

    }

    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println("bu bir test metotudur 1.");
    }
    @Test
    public void shouldAnswerWithTrue2()
    {
        System.out.println("bu bir test metotudur 2.");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("ben her test metotundan sonra koşarım..");
    }

    @BeforeClass
    public static void beforeClass() throws Exception {

    }
}
