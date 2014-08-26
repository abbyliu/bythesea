package leecode.reversewordsinstring;

public class Solution2 {
	 public String reverseWords(String s) {
	      if (s == null || s.length() == 0) return s;
	      String trimed = s.trim();
	      String[] splits = trimed.split(" ");
	      StringBuilder builder = new StringBuilder();
	      int count = 0;
	      for (int i = splits.length-1;i>=0;i--) {
	          if (splits[i].length()==0) continue;
	          if (count >0) builder.append(" ");
	          builder.append(splits[i]);
	          count++;
	      }
	      return builder.toString();
	}
	
}