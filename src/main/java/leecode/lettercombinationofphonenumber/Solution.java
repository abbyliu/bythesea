package leecode.lettercombinationofphonenumber;

import java.util.ArrayList;
import java.util.List;
/*
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
	
	public List<String> letterCombinations2(String digits) {
		List<String> result = new ArrayList<>();
		if (digits== null || digits.length() == 0) {
			result.add("");
			return result;
		}
		result.addAll(getStrings(digits.charAt(digits.length()-1)));
		for (int i = digits.length()-2; i>=0; i--) {
			char ch = digits.charAt(i);
			List<String> strs = getStrings(ch);
			List<String> tpp = new ArrayList<>();
			for (String str: strs) {
				for (String tp: result) {
					tpp.add(str+ tp);
				}
			}
			result = tpp;
		}
		return result;
	}
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			result.add("");
			return result;
		}
		result = getResult(digits, 0);
		return result;
	}
	private List<String> getResult(String digits, int i) {
		if (i == digits.length()-1) {
			return getStrings(digits.charAt(i));
		}
		List<String> ss = getResult(digits, i+1);
		List<String> sn = getStrings(digits.charAt(i));
		List<String> ret = new ArrayList<>();
		for (String sn1: sn) {
			for (String sss: ss) {
				ret.add(sn1+sss);
			}
		}
		return ret;
	}
	private List<String> getStrings(char charAt) {
		List<String> result = new ArrayList<>();
		switch (charAt) {
		case '2':
			result.add("a");result.add("b");result.add("c");break;
		case '3':
			result.add("d");result.add("e");result.add("f");break;
		case '4':
			result.add("g");result.add("h");result.add("i");break;
		case '5':
			result.add("j");result.add("k");result.add("l");break;
		case '6':
			result.add("m");result.add("n");result.add("o");break;
		case '7':
			result.add("p");result.add("q");result.add("r");result.add("s");break;
		case '8':
			result.add("t");result.add("u");result.add("v");break;
		case '9':
			result.add("w");result.add("x");result.add("y");result.add("z");break;

		}
		return result;
	}
}
