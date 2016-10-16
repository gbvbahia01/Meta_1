/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guilherme.bahia.meta_1;

import java.util.regex.*;
import java.util.Scanner;

/**
 *
 * @author Guilherme
 */
public class Exercise5 {

    public static String patternString = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    public static Pattern pattern = Pattern.compile(patternString);
    
    public class MyRegex {
        private Matcher matcher = null;
        public MyRegex(String iP) {
            matcher = pattern.matcher(iP);
        }

        public boolean isMatches() {
            return matcher.find();
        }
    }

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String iP = in.next();
            MyRegex mr = new Exercise5().new MyRegex(iP);
            System.out.println(mr.isMatches());
        }
    }
}
