package leecode.reversewordsinstring;

public class Soltuion3 {
	public String reverseWords(String s) {
	    if (s == null || s.length() == 0) return s;
	    String trimed = s.trim();
	    StringBuilder builder = new StringBuilder();
	    boolean newWord = false;
	    int idx = 0;
	    for (int i = 0; i < trimed.length();i++ ) {
	        char c = trimed.charAt(i);
	        if (c == ' ') {
	            if (newWord) {
	                insertWord(trimed, idx, i, builder);
	                newWord = false;
	            }
	        } else {
	            if (!newWord) {
	                newWord = true;
	                idx = i;
	            }
	        }
	    }
	    if (newWord) {
	        insertWord(trimed, idx, trimed.length(), builder);
	    }
	    return builder.toString();
	}
	
	private void insertWord(String string, int start, int end, StringBuilder builder) {
            String sub = string.substring(start, end);
            if (builder.length() ==0) {
	                builder.insert(0, sub);
	        } else {
	            builder.insert(0, ' ');
	            builder.insert(0, sub); 
            }
	}
}
