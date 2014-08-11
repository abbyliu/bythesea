package leecode.ispalindrome;
/*
 * Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
O(n), O(1)
 */
public class Solution {
	public boolean isPalindrome2(String s) {
		if (s == null || s.trim().length() == 0) return true;
		String st = s.trim().toLowerCase();
		int i = 0;
		int j = st.length()-1;
		while (i < j) {
			char c1 = st.charAt(i);
			char c2 = st.charAt(j);
			boolean c1y = isCharacter(c1);
			boolean c2y = isCharacter(c2); 
			if (c1y&& c2y) {
				if (c1 != c2) {
					return false;
				} else {
					i++;
					j--;
				}
			} else {
				if (!c1y) {i++;}
				if (!c2y) {j--;}
			}
		}
		return true;
	}
	private boolean isCharacter(char c) {
		return (c >= 'a' && c <='z')|| (c>='0'&&c<='9');
	}
    public boolean isPalindrome(String s) {
    	if (s == null || s.length() <= 1) return true;
    	int i = 0;
    	int j = s.length() -1;
    	while (i < j) {
    		char c1 = s.charAt(i);
    		char c2 = s.charAt(j);
    		if (!Character.isAlphabetic(c1) && !Character.isDigit(c1)) {
    			i++;continue;
    		} 
    		if (!Character.isAlphabetic(c2) && !Character.isDigit(c2)) {
    			j--;continue;
    		}
    		if (!String.valueOf(c1).equalsIgnoreCase(String.valueOf(c2))) {
    			return false;
    		} else {
    			i++;j--;
    		}
    		
    	}
    	return true;
    }
}
