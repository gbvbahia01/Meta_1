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
public class Exercise5Test {
    
    public Exercise5Test() {
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
     * Test of main method, of class Exercise5.
     */
    @Test
    public void testMain() {
        assertTrue(new Exercise5().new MyRegex("000.12.12.034").isMatches());
        assertTrue(new Exercise5().new MyRegex("121.234.12.12").isMatches());
        assertTrue(new Exercise5().new MyRegex("23.45.12.56").isMatches());
        
        assertFalse(new Exercise5().new MyRegex("000.12.234.23.23").isMatches());
        assertFalse(new Exercise5().new MyRegex("000.12.234.23.23").isMatches());
        assertFalse(new Exercise5().new MyRegex(".213.123.23.32").isMatches());
        assertFalse(new Exercise5().new MyRegex("23.45.22.32.").isMatches());
        assertFalse(new Exercise5().new MyRegex("I.Am.not.an.ip").isMatches());
    }
    
}
