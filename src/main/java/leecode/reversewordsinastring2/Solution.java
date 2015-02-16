package leecode.reversewordsinastring2;
/* Reverse Words in a String II 
 * in place
 */
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() <=0) {
            return s;
        }
        
        StringBuilder builder = new StringBuilder();
        
        boolean inWord = false;
        int idx = 0;
        for (int i = s.length() -1 ; i >=0 ; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                if (inWord) {
                    inWord = false;
                }
            } else {
                if (!inWord) {
                    inWord = true;
                    if (builder.length() != 0) {
                        builder.append(' ');
                    }
                    idx = builder.length();
                }
                builder.insert(idx, c);
            }
        }

        return builder.toString();
    }
}
