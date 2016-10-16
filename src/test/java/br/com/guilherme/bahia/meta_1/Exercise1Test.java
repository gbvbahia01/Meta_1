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
public class Exercise1Test {
    
    public Exercise1Test() {
    }
    

    /**
     * Test of Braces method, of class Exercise1.
     */
    @Test
    public void testBraces() {
        System.out.println("Braces");
        String[] values = {"{}[]()","{[}]}"};
        String[] expResult = {"YES", "NO"};
        String[] result = Exercise1.Braces(values);
        assertArrayEquals(expResult, result);
 
        String[] values2 = {"{a}[b](cde)","{)[}](}"};
        String[] expResult2 = {"YES", "NO"};
        result = Exercise1.Braces(values2);
        assertArrayEquals(expResult2, result);
        
        String[] values3 = {"{1 + [b + 3](cde)}","{(2 + 3) + 3 * [4 + 2]}"};
        String[] expResult3 = {"YES", "YES"};
        result = Exercise1.Braces(values2);
        assertArrayEquals(expResult2, result);
    }


    
}
