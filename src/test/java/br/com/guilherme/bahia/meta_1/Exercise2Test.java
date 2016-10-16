/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guilherme.bahia.meta_1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Guilherme
 */
public class Exercise2Test {

    public Exercise2Test() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Exercise2.
     */
    @Test
    public void testPower() throws Exception {
        Exercise2.MyCalculator calc = new Exercise2().new MyCalculator();
        int expResult = 243;
        int[] values = {3, 5};
        assertEquals(expResult, calc.power(values[0], values[1]));

        int expResult2 = 16;
        int[] values2 = {2, 4};
        assertEquals(expResult2, calc.power(values2[0], values2[1]));
    }

    @Test(expected = Exception.class)
    public void testPowerError() throws Exception {
        Exercise2.MyCalculator calc = new Exercise2().new MyCalculator();
        int[] values = {-3, 5};
        calc.power(values[0], values[1]);
        fail("A exception must be thrown");
    }
}
