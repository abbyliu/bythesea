package leecode.generateparentheses;

import java.util.ArrayList;
import java.util.List;
/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

 Catalan number, complexity
 Cn = 2n!/(n+1)!n!
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		List<String> result = s.generateParenthesis2(2);
		System.out.println(result);
	}
	
	public List<String> generateParenthesis2(int n) {
		List<String> result = new ArrayList<>();
		if (n <=0) return result;
		generateResult(0, 0, n, "", result);
		return result;
	}
	
    private void generateResult(int left, int right, int total, String str,
			List<String> result) {
    	if (left == total && right == total) {
    		result.add(str);
    		return;
    	}
    	if (left < total && left >=right) {
    		generateResult(left+1, right, total, str+"(", result);
    	}
    	if (right < total && right < left) {
    		generateResult(left, right+1, total, str+")", result);
    	}
	}

	public List<String> generateParenthesis(int n) {
    	List<String> result = new ArrayList<>();
    	if (n <=0) return result;
    	String str = "";
    	result = generate(n, n, str);
    	return result;
    }

	private List<String> generate(int n, int n2, String str) {
		if (n == 0 && n2==0) {
			List<String> st = new ArrayList<>();
			st.add(str);
			return st;
		}
		List<String> s = new ArrayList<>();
		if (n > 0) {
			s.addAll(generate(n-1, n2, str + "("));
		}
		if (n2 > n && n2 > 0) {
			s.addAll(generate(n, n2-1, str+ ")"));
		}
		return s;
	}

}
