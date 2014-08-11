package leecode.addbinary;
//Given two binary strings, return their sum (also a binary string). 
//For example,
//a = "11"
//b = "1"
//Return "100".    O(a.length()+b.length())
public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = a.length() -1, j = b.length()-1; i>=0 || j>=0; i--,j--) {
        	int a1 = 0;
        	if (i>=0) a1 = a.charAt(i) - '0';
        	int b1 = 0;
        	if (j>=0) b1 = b.charAt(j) - '0';
        	int v = (a1+b1 + carry) % 2;
        	carry = (a1 + b1+ carry)/2;
        	builder.insert(0, v);
        }
        if (carry != 0) {
        	builder.insert(0, 1);
        }
        return builder.toString();
    }
    
    public String addBinary2(String str1, String str2) {
    	if (str1 == null && str2 == null) return null;
    	if (str1 == null) return str2;
    	if (str2 == null) return str1;
    	
    	StringBuilder builder = new StringBuilder();
    	int carry = 0;
    	for (int i = str1.length() -1 ,  j = str2.length()-1;
    			i >=0 || j>=0 ; i--,j--) {
    		int char1Value = 0;
    		if (i >=0) {
    			char1Value = str1.charAt(i) - '0';
    		}
    		int char2Value = 0;
    		if (j>=0) {
    			char2Value = str2.charAt(j) - '0';
    		}
    		int value = char1Value + char2Value + carry;
    		builder.insert(0, value%2);
    		carry = value/2;
    	}
    	if (carry >0) {
    		builder.insert(0, "1");
    	}
    	return builder.toString();
    }
}