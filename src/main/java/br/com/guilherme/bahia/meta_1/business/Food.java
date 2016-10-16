/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guilherme.bahia.meta_1.business;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Guilherme
 */
public class Food {

    public String serving(){
        return "I'm serving " + getClass().getSimpleName();
    }
    
    public String getSuperClassName(){
        return "Our superclass is: Food";
    }
    
    @Override
    public String toString() {
        return "My name is: " + getClass().getSimpleName();
    }
}
