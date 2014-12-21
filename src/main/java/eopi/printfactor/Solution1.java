package eopi.printfactor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution1 {
	 
    public static void PrintFactors(int n) {
        List<Integer> factors = new ArrayList<Integer>();
        Set<String> outputs = new TreeSet<String>();
        divide(n, factors, outputs);
 
        for (String s : outputs) {
            System.out.println(s);
        }
    }
 
    public static void divide(int n, List<Integer> factors, Set<String> outputs) {
        if (n == 1) {
            List<Integer> fs = new ArrayList<>(factors);
            Collections.sort(fs, Collections.reverseOrder());
            String output = "";
            for (Integer f : fs) {
                output += " * " + f;
            }
            outputs.add(output.substring(3));
        } else {
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    factors.add(i);
                    divide(n / i, factors, outputs);
                    factors.remove(factors.size()-1);
                }
            }
        }
    }
    
    public static void main(String[] args) {
    	PrintFactors(12);
    }
}