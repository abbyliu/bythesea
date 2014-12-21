package leecode.excelsheetcolumntitle;

public class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder builder = new StringBuilder();
        
        while ( n > 0) {
        	if ( n <= 26) {
        		builder.insert(0, (char)('A' + (n-1)));
        		break;
        	} else {
        		int v = (n-1) % 26;
           		builder.insert(0, (char)('A' + v));
           	    n = (n-1)/26;
        	}
        	
        }
        
        return builder.toString();
    }
    
}