/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Guilherme
 */
public class Test extends Thread {
    
    B b = new B();
    
    void getSKU() { ; }
    
    public static void main(String[] args) throws Exception {
        Test run = new Test();
        Thread a = new Thread(run);
        Thread b = new Thread(run);
        a.setName("A");
        b.setName("B");
        a.start();
        while (!a.getState().equals(State.TERMINATED)){
            Thread.currentThread().sleep(1);
        }
        b.start();
    }

    @Override
    public void run() {
      for (int i = 0; i < 8; i++) {
          try {
              Thread.sleep(100);
              System.out.println(Thread.currentThread().getName());
          } catch (Exception e) {
              
          }
          
      }
    }
    
    
    
    public static class B {
        public static synchronized void printName() {
            try {
                System.out.println("printName");
                Thread.sleep(5 * 1000);
            }catch (InterruptedException e) {
                
            }
        }
        
        public static synchronized void printValue() {
                System.out.println("printValue");
        }
    }
}
