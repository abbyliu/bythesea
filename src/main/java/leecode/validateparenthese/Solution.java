package leecode.validateparenthese;

import java.util.Stack;
/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean isValid(String s) {
    	if (s== null || s.length() == 0) return false;
    	if (s.length() % 2 != 0) return false;
    	Stack<Character> st = new Stack<>();
    	for (int i = 0; i < s.length() ;i++) {
    		char c = s.charAt(i);
    		switch(c) {
    		case '{':
    		case '[':
    		case '(': st.push(c);break;
    		case ')': if (st.isEmpty()|| st.pop() != '(') return false;break;
    		case ']': if (st.isEmpty()|| st.pop() != '[') return false;break;
    		case '}': if (st.isEmpty()|| st.pop() != '{') return false;break;
    		default: return false;
    		}
    	}
    	return st.isEmpty();
    }
}
