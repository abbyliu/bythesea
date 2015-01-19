package leecode.longestparentheses;

import java.util.Stack;
/* Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
O(n)
O(n) 
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss = "(()()";
		Solution s = new Solution();
		s.longestValidParentheses(ss);
	}
    public int longestValidParentheses(String s) {
    	if (s == null || s.length() <=1) return 0;
    	Stack<Integer> begin = new Stack<>();
    	int max =0;
    	int idx = 0;
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == '(') {
    			begin.push(i);
    		} else {
    			if (begin.isEmpty()) {
    				idx = i+1;
    			} else {
    				begin.pop();
    				if (begin.isEmpty()) {
    					max = Math.max(max, i - idx +1);
    				} else {
    					max = Math.max(max, i - begin.peek());
    				}
    			}
    		}
    	}
    	return max;
    }
}
