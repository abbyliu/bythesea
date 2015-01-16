package leecode.largestnumber;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] num) {
        if (num == null || num.length == 0) {
            return "";
        }
        String[] output = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            output[i] = String.valueOf(num[i]);
        }
        Arrays.sort(output, new StringComparator());
        
        StringBuilder builder = new StringBuilder();
        for (String str: output) {
        	builder.append(str);
        }
        while (builder.charAt(0) == '0' && builder.length() > 1) {
        	builder.deleteCharAt(0);
        }
        return builder.toString();
    }
    
    static class StringComparator implements Comparator<String> {
            public int compare(String a, String b) {
            	String ab = a + b;
                String ba = b + a;

                // Compare directly two options of combination.
                return ba.compareTo(ab);
            	
            	/*int i = 0; int j = 0;
            	char c1 = '0';
            	char c2 = '0';
            	for (i = 0, j = 0; i < o1.length()&& j< o2.length(); i++,j++ ) {
            		c1 = o1.charAt(i);
            		c2 = o2.charAt(j);
            		if (c2 != c1) {
            			return c2 - c1; 
            		}
            	}
            	if ( i == o1.length() && j == o2.length()) {
            		return 0;
            	} else if (i < o1.length()) {
            		return c2 - o1.charAt(i); 
            	} else {
            		return o2.charAt(j) - c1;
            	}*/
            }

    }
    
    public static void main(String[] args) {
    	int[] strs = new int[] {824,938,1399,5607,6973,5703,9609,4398,8247};
    	LargestNumber lg = new LargestNumber();
    	System.out.println(lg.largestNumber(strs));
    }
}
