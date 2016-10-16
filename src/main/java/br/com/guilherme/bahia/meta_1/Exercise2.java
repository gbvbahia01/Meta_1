/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guilherme.bahia.meta_1;

import java.util.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 * 2) The MyCalculator class and int power(int,int) method are provided for you in the editor. The
 * power(int,int) method has two parameters, n and p, and either calculates and returns np or throws
 * an exception in the event that one or both arguments passed to it are negative. Complete the main
 * method in the Solution class so it performs the following tasks: Use the Scanner class to read
 * successive lines of two space-separated integers (in the form n p) from STDIN until no more input
 * is detected. Print a line of output for each line of input. If n ≥ 0 and p ≥ 0, it prints np;
 * otherwise, it prints . non-negative java.lang.Exception: n and p should be Input Format Each line
 * consists of two space-separated integers, n and p, respectively; continue scanning input until no
 * more input is detected. Output Format For each line of input, print the corresponding output (see
 * Problem Statement above) on a new line. Sample Input 0 35 24 -1 -2 -1 3 Sample Output 0 243 16
 * java.lang.Exception: n and p should be non-negative java.lang.Exception: n and p should be
 * non-negative Explanation In the first two lines, n and p are positive so the value of np is
 * printed. In the third line, both n and p are negative and an exception is thrown. In the fourth
 * line, n is negative and an exception is thrown.
 *
 * @author Guilherme
 */
public class Exercise2 {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        MyCalculator calc = new Exercise2().new MyCalculator();
        Integer[] powers = new Integer[2];

        while (in.hasNext()) {
            String nextLine = in.nextLine();
            powers[0] = Integer.valueOf(StringUtils.substringBefore(nextLine, " ").trim());
            powers[1] = Integer.valueOf(StringUtils.substringAfter(nextLine, " ").trim());
            try {
                 System.out.println(calc.power(powers[0], powers[1]));
            } catch (Exception ex) {
                System.out.println(ex.getClass().getCanonicalName() + ":" + ex.getMessage());
            }
        }
    }

    class MyCalculator {

        int power(int n, int p) throws Exception {
            if (n < 0 || p < 0) {
                throw new Exception("n and p should be non - negative");
            }
            if (p == 0) {
                return 1;
            }
            return n * power(n, p - 1);
        }
    }
}
