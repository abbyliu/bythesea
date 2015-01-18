package leecode.largestnumber;

import java.util.Arrays;
import java.util.Comparator;

/* Largest Number */
public class LargestNumber {
    public String largestNumber(int[] num) {
        String[] output = new String[num.length];
        StringBuilder builder = new StringBuilder();

        if (num == null || num.length == 0) {
            return "";
        }
        
        for (int i = 0; i < num.length; i++) {
            output[i] = String.valueOf(num[i]);
        }

        Arrays.sort(output, new StringComparator());
        
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

                return ba.compareTo(ab);
            }
    }
    
    public static void main(String[] args) {
    	int[] strs = new int[] {824,938,1399,5607,6973,5703,9609,4398,8247};
    	LargestNumber lg = new LargestNumber();
    	System.out.println(lg.largestNumber(strs));
    }
}
