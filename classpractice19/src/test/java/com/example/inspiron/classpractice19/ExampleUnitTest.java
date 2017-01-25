package com.example.inspiron.classpractice19;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void MathsAddTest()
    {
        Maths maths = new Maths();
        int r = maths.addition(4,4);
        assertEquals(8,r);
    }

    @Test
    public void MathsMultiplyTest()
    {
        Maths maths = new Maths();
        int r = maths.multiply(4,4);
        assertEquals(16,r);
    }

}