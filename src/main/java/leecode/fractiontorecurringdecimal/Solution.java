package leecode.fractiontorecurringdecimal;

import java.util.HashMap;
import java.util.Map;

/* Fraction to Recurring Decimal */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
            long num = Math.abs((long) numerator);
            long den = Math.abs((long) denominator);
            boolean negative = ((numerator < 0) ^ (denominator < 0)
                               ) && (num != 0);
            
	        StringBuilder builder = new StringBuilder();
	        
	        builder.append(num / den);
	        num %= den;
	        
	        if (num != 0) {
	        	builder.append(".");
		        Map<Long, Integer> map = new HashMap<>();
		        int idx = builder.length();
		        
		        while (num != 0 && !map.containsKey(num)) {
		            map.put(num, idx);
		            num *= 10;
		            builder.append((num / den));
		            num = num % den;
		            idx++;
		        }
	
		        if (num != 0) {
		        	int location = map.get(num);
		        	builder.insert(location, "(")
		        		.append(")");
		        } 
	        }
	        
	        if (negative) {
	        	builder.insert(0, "-");
	        }
	        
	        return builder.toString();        
    }
}