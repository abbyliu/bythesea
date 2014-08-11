package leecode.lengthoflastword;
/*
 * Given a string s consists of upper/lower-case alphabets and empty space 
 * characters ' ', return the length of last word in the string.
 * O(s.length())
 * O(1)
 */
public class Solution {
	
	public int lengthOfLastWord2(String s) {
		if (s == null || s.length() == 0) return 0;
		boolean inword = false;
		boolean startWord = true;
		int i = 0;
		int startIdx = 0;
		int length = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			if (isChar(ch)) {
				if (startWord) {
					if (!inword) {
						inword = true;
						startIdx = i;
					} 
				}
			} else if (isSpace(ch)) {
				if (inword) {
					inword = false;
					length = i - startIdx;
				}
				startWord = true;
			} else {
				inword = false;
				startWord = false;
			}
			i++;
		}
		if (inword) {
			length = i - startIdx;
		}
		return length;
	}
	
	private boolean isSpace(char ch) {
		return ch == ' ';
	}

	private boolean isChar(char ch) {
		return (ch>='a' && ch<='z')
				|| (ch>='A' && ch<='Z');
	}
    public int lengthOfLastWord(String s) {
    	if (s == null || s.length() == 0) return 0;
    	boolean inWord = false;
    	boolean startWord = true;
    	int startIdx = 0;
    	int idx = 0;
    	int lastwordLength = 0;
    	while (idx < s.length()) {
    		char ch= s.charAt(idx);
    		if (Character.isAlphabetic(ch)) {
    			if (startWord) {
	    			startIdx = idx;
	    			inWord = true;
	    			startWord = false;
    			} 
    		} else if (ch == ' ') {
    			if (inWord) {
    				inWord = false;
    				int length = (idx -1) - startIdx +1;
    				lastwordLength = length;
    				startWord = true;
    			} 
    		} else {
    			inWord = false;
    			startWord = false;
    		}
			idx ++;
    	}
    	if (inWord) {
    		int length = (idx -1) - startIdx+1;
    		lastwordLength = length;
    	}
    	return lastwordLength;
    }
    
    public static void main(String[] args) {
    	Solution s= new Solution();
    	s.lengthOfLastWord("    day");
    }
}