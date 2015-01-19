package leecode.longestcommonprefix;

/* Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings. 
 * O(n* shortest string len)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	   public String longestCommonPrefix(String[] strs) {
		   if (strs == null || strs.length == 0) return "";
		   int min = strs[0].length();
		   String ma = strs[0];
		   for (int i = 1; i < strs.length ;i++) {
			   if (strs[i].length() < min) {
				   min = strs[i].length();
				   ma = strs[i];
			   }
		   }
		   if (min == 0) return "";
		   int idx = 0;
		   while(true && idx < min) {
			   char ch = ma.charAt(idx);
			   for (int i = 0;i < strs.length; i++) {
				   if (ch != strs[i].charAt(idx)) {
					   return ma.substring(0, idx);
				   }
			   }
			   idx++;
		   }
		   return ma;
	   }

		public String longestCommonPrefix2(String[] strs) {
		    if (strs == null || strs.length==0) return "";
		    String shortest = strs[0];
		    for (int i = 1; i < strs.length;i++) {
		        if (strs[i].length() < shortest.length()) {
		            shortest = strs[i];
		        }
		    }
		    for (int i = 0; i < shortest.length();i++) {
		        char c = shortest.charAt(i);
		        for (int j = 0; j < strs.length;j++) {
		            if (strs[j].charAt(i)!= c) {
		                return shortest.substring(0,i);
		            }
		        }
		    }
		    return shortest;
		}
}
