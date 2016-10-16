/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guilherme.bahia.meta_1;

/**
 *Examine the following code, it includes an inner class, what is the result?
    public final class Test4 {
        class Inner {
                void test() {
                        if (Test4.this.flag); {
                            sample();
                        }
                } 
        }
private boolean flag = true; 
public void sample() {
    System.out.println("Sample");
}
public Test4() {
(new Inner()).test();
}
public static void main(String args []) {
    new Test4();
}
}
    (X) Prints out "Sample"
    ( ) Program produces no output but terminates correctly
    ( ) Program does not terminate.
    ( ) The program will not compile
 * @author Guilherme
 */
public class Exercise9 {
    
}

   final class Test4 {
        class Inner {
                void test() {
                        if (Test4.this.flag); {
                            sample();
                        }
                } 
        }
private boolean flag = true; 
public void sample() {
    System.out.println("Sample");
}
public Test4() {
(new Inner()).test();
}
public static void main(String args []) {
    new Test4();
}
}