package com.cb.square;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SquareTest {
    /*
     * Your customer has requested a Java Class "com.cb.square.com.cb.square.Square" with one Method "calculate"
     * This method takes a positive int number as a parameter and returns the square of the number
     *
     * The Method looks like this:
     * public int calculate(int i) throws IllegalArgumentException
     *
     * If a negative number is passed an IllegalArgumentException should be thrown
     * You have been given this Test Class
     * Implement the com.cb.square.com.cb.square.Square Class and Calculate Method and run the tests until all of them pass
     *  */
    private Square square;

    @BeforeEach //This Method will be executed before each other test method
    void setUp(){
        square = new Square();
    }

    @Test //Tests for squared Values
    void calculateTest(){
        //expected Value is 4 when we calculate 2*2
        assertEquals(4, square.calculate(2));
        //expected Value is 9 when we calculate 3*3
        assertEquals(9, square.calculate(3));
        //expected Value is 0 when we calculate 0*0
        assertEquals(0, square.calculate(0));
        //expected Value is 1 when we calculate 1*1
        assertEquals(1, square.calculate(1));
    }

    @Test //Test for an IllegalArgument
    void exceptionCalculateTest(){
        //When we call the Method with -1, we expect that an IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> square.calculate(-1));
    }
}
