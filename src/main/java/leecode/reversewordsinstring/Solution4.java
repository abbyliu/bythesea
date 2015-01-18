package leecode.reversewordsinstring;

/* Reverse Words in a String */
public class Solution4 {
    public String reverseWords(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }
        
        String[] splits = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < splits.length; i++) {
            if (splits[splits.length-1-i].trim().length() > 0) {
                if (builder.length() > 0) {
                    builder.append(" ");
                }
                builder.append(splits[splits.length-1-i]);
            }
        }
        
        return builder.toString();
    }
    
    // fastest
    public String reverseWords2(String s) {
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
    
    public static void  main(String[] args) {
    	Solution4 s4 = new Solution4();
    	s4.reverseWords(" ");
    }
}
