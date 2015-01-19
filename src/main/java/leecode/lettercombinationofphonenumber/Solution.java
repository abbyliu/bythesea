package leecode.lettercombinationofphonenumber;

import java.util.ArrayList;
import java.util.List;
/* Letter Combinations of a Phone Number
 * Given a digit string, return all possible letter combinations that the number could represent.
 * O(3*3*3*3....*4) 
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<String> letterCombinations(String digits) {
	    List<String> result = new ArrayList<>();
	    result.add("");
	    if (digits == null || digits.length() == 0) return result;
	    List<String> tmp = new ArrayList<>();
	    for (int i = 0; i < digits.length(); i++ ) {
	        char c = digits.charAt(i);
	        List<Character> chars = getChars(c);
	        for (String s : result) {
	            for (Character cc: chars) {
	                tmp.add(s+cc);
	            }
	        }
	        result = tmp;
	        tmp = new ArrayList<>();
	    }
	    return result;
	}
	List<Character> getChars(char c) {
	    List<Character> chars = new ArrayList<>();
	    if (c == '0') {
	        chars.add(' ');
	    } else if (c == '2') {
	        chars.add('a');chars.add('b');chars.add('c');
	    } else if (c == '3') {
	        chars.add('d');chars.add('e');chars.add('f');
	    } else if (c == '4') {
	        chars.add('g');chars.add('h');chars.add('i');
	    } else if (c == '5') {
	        chars.add('j');chars.add('k');chars.add('l');
	    } else if (c == '6') {
	        chars.add('m');chars.add('n');chars.add('o');
	    } else if (c == '7') {
	        chars.add('p');chars.add('q');chars.add('r');chars.add('s');
	    } else if (c == '8') {
	        chars.add('t');chars.add('u');chars.add('v');
	    } else if (c == '9') {
	        chars.add('w');chars.add('x');chars.add('y');chars.add('z');
	    }
	    return chars;
	}	
}
