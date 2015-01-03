package leecode.reversewordsinstring;

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
    
    public static void  main(String[] args) {
    	Solution4 s4 = new Solution4();
    	s4.reverseWords(" ");
    }
}
