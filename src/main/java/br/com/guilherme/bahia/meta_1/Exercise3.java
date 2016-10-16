/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guilherme.bahia.meta_1;

import br.com.guilherme.bahia.meta_1.business.Fastfood;
import br.com.guilherme.bahia.meta_1.business.Food;
import br.com.guilherme.bahia.meta_1.business.Fruits;

/**
 *
 * @author Guilherme
 */
public class Exercise3 {
    
    abstract class Solution<T extends Food>{
        abstract T getFood();
    }
    
    
    class FoodFactory extends Solution {
        @Override
        Food getFood() {
            return new Fastfood();
        }
 }
    class FruitsFatory extends Solution { 
        @Override
        Food getFood() {
            return new Fruits();
        }
    }
    
    public static void main(String[] args){
        Solution<Fastfood>  ffFactory = new Exercise3().new FoodFactory();
        Fastfood fastfood = ffFactory.getFood();
        Solution<Fruits> fruitsFactory = new Exercise3().new FruitsFatory();
        Fruits fruits = fruitsFactory.getFood();
        
        System.out.println(fastfood.toString());
        System.out.println(fruits.toString());
        
        System.out.println(fastfood.getSuperClassName());
        
        System.out.println(fastfood.serving());
        System.out.println(fruits.serving());
    }
}
