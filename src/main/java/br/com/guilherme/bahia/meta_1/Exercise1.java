/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.guilherme.bahia.meta_1;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/**
 * 1) braces in a string are considered to be balanced if the following criteria are met: For every
 opening brace (i.e.: (, {, or [), there is a matching closing brace (i.e.: ), }, or ]) of the
 same type (i.e.: (matches ), { matches }, and [ matches ]). An opening brace must appear before
 (to the left of) its matching closing brace (e.g.: ]{}[ is not balanced). No unmatched braces lie
 between some pair of matched braces. For example, ({[]}) is balanced, but {[}] and [{)] are not
 balanced. Complete the braces function in your editor. It should take an array of strings named
 values as a parameter, determine if all its braces are balanced, and then return an array of
 strings where each element indicates whether or not the element in the corresponding index of
 values was balanced. If the string in values[i] (where 0 ≤ i ≤ |values| - 1) has balanced braces,
 then index i in the return array should contain the string YES; otherwise, index i in the return
 array should contain the string .

 NO Input Format Constraints Input from stdin is handled by the locked stub code in your editor.
 The first line contains N, the length of values. Each line i of the N subsequent lines describes
 values[i]. 1 ≤ |values| ≤ 15 1 ≤ |values[i]| ≤ 100, where 0 ≤ i ≤ |values| Output Format Sample
 Output Printing the contents of your returned array to stdout is handled by the locked stub code
 in your editor. Each line i of the Nlines of output denotes whether or not the string in
 values[i] was balanced. Sample Input values={" "," "} {}[]() {[}]} return={" "," "} YES NO
 Explanation values[0]: {}[]() meets the criterion for a balanced string, so index 0 in our return
 array should contain the string YES. values[1]: {[}] contains unmatched braces between a matched
 pair (in the substrings [}, {[}, and [}]), so index 1 in our return array should contain the
 string NO.
 *
 * @author Guilherme
 */
public class Exercise1 {

private static final Map<Character, Character> BRACES = new HashMap<>();
	static {
		BRACES.put('(', ')');
		BRACES.put('{', '}');
		BRACES.put('[', ']');
	}

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = FileUtils.currentFolder("src/main/java/br/com/guilherme/bahia/meta_1/ex1.txt"); //System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String[] res;
        int _values_size = 0;
        System.out.println("Number of lines:");
        _values_size = Integer.parseInt(in.nextLine());
        String[] _values = new String[_values_size];
        String _values_item;
        for (int _values_i = 0; _values_i < _values_size; _values_i++) {
            try {
                System.out.println("next line:");
                _values_item = in.nextLine();
            } catch (Exception e) {
                _values_item = null;
            }
            _values[_values_i] = _values_item;
        }
        res = braces(_values);
        for (int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }
        bw.close();
    }
    
     static String[] braces(String[] values) {
        String[] toReturn = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            if (evaluate(values[i])) {
                toReturn[i] = "YES";
            } else {
                toReturn[i] = "NO";
            }
        }
        return toReturn;
    }

    private static boolean evaluate(String value) {
       Stack<Character> st = new Stack<>();
		Set<Character> keys = BRACES.keySet();
		char[] c = value.toCharArray();
		for (int i = 0; i < value.length(); i++) {
			for(Character key : keys){
				if(key.equals(c[i])){
					st.push(key);
					break;
				}else if(BRACES.get(key).equals(c[i])){
					if(st.isEmpty()){
						return false;
					}
					Character chk = st.pop();
					if(!chk.equals(key)){
						return false;
					}
					break;
				}
			}
		}
		return st.isEmpty();
    }
}
