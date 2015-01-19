package leecode.lengthoflastword;
/* Length of Last Word
 * Given a string s consists of upper/lower-case alphabets and empty space 
 * characters ' ', return the length of last word in the string.
 * O(s.length())
 * O(1)
 */
public class Solution {
	

	
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
    
    public int lengthOfLastWord2(String s) {
        if (s == null || s.length()==0) return 0;
        int idx = s.length() -1;
        
        int begin = idx;
        boolean inword = false;
        while (idx >=0) {
            char c = s.charAt(idx);
            if (c == ' ') {
                if (inword) {
                    return begin - idx;
                }
            } else if ((c >='a' && c<='z') || (c >= 'A' && c <= 'Z')){
                if (!inword) {
                    inword = true;
                    begin = idx;
                }
            } else {
                inword = false;
            }
            idx--;
        }
        
        if (inword) {
            return begin - idx;    
        }
        return 0;
    }
    
    public static void main(String[] args) {
    	Solution s= new Solution();
    	s.lengthOfLastWord("    day");
    }
}