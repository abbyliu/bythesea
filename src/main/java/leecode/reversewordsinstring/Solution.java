package leecode.reversewordsinstring;
/*
 *  Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the". 

 */
public class Solution {
	
	 public String reverseWords2(String s) {
		  if (s == null || s.length() == 0) return s;
		  
		  String trimed = s.trim();
		  
		  if (trimed.length() <= 1) {
			  return trimed;
		  }
		  
		  String[] splits = trimed.split(" ");
		  StringBuilder builder = new StringBuilder();
		  int idx  = 0;
		  for (int i = splits.length-1; i>=0; i--) {
		      if (splits[i].equals("")){ 
		         continue;
		      }
		      if (idx > 0) {
		         builder.append(" ");
		      }
		      builder.append(splits[i]);
		      idx++;
		  }
	
		  return builder.toString();
	}
	 
    public String reverseWords(String s) {
        if (s == null) {
        	return s;
        }
        String str = s.trim();
        if (str.length() <= 1) {
        	return str;
        }
        String[] strs = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
        	String ss = strs[strs.length - 1 - i].trim();
        	if (ss.length() == 0) {
        		continue;
        	}
        	if (i > 0) {
        		builder.append(" ");
        	}
        	builder.append(ss);
        }
        return builder.toString();
    }
    
    public static void main(String[] args) {
    	Solution so = new Solution();
    	System.out.println(so.reverseWords2("    a   b   "));
    }
}
