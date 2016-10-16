/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guilherme.bahia.meta_1;

/**
 *
 * @author Guilherme
 */
public class Exercise4 {
    
    public static void main(String[] args) {
        Arithmetic arithmetic = new Exercise4().new Adder();
        System.out.println("My superclass is:" + arithmetic.getClass().getSuperclass().getSimpleName());
        System.out.print(arithmetic.add(21, 21));
        System.out.print(" ");
        System.out.print(arithmetic.add(13, 13) /2 );
        System.out.print(" ");
        System.out.print(arithmetic.add(10, 10));
    }
    
    class Adder extends Arithmetic{
        @Override
        int add(int a, int b) {
            return a + b;
        }
        
    }
    
    abstract class Arithmetic{
        abstract int add(int a,int b);
    }
            
}
