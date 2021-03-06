package leecode.oneeditdistance;

public class Solution {
	public static boolean edit(String s1, String s2) {
	    if(s2.length() < s1.length()) {
	        return edit(s2, s1);
	    }    
	    if(s1.length() + 1 < s2.length()) {
	        return false;
	    }   

	    int i = 0;
	    while(i < s1.length()) {
	        if(s1.charAt(i) != s2.charAt(i)) {
	            if(s1.length() == s2.length()) {
	                return s1.substring(i+1).equals(s2.substring(i+1));
	            }else {
	                return s1.substring(i).equals(s2.substring(i+1));
	            }   
	        }   
	        i++; 
	    }   
	    return s1.length() != s2.length();
	}
	
	public static void main(String[] args) {
		System.out.println(edit("xyz", "xz"));
		System.out.println(edit("xyz", "xyk"));
		System.out.println(edit("xy", "xyz"));

		System.out.println(edit("xyz", "xyz"));
		System.out.println(edit("xyz", "xzy"));
		System.out.println(edit("x", "xyz"));
	}
}
