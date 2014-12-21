package leecode.fractiontorecurringdecimal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
            long num = Math.abs((long)numerator);
            long den = Math.abs((long)denominator);
            boolean negative = ((numerator < 0) ^ (denominator < 0)
                               ) && (num !=0);
	        String ret = Long.toString(num / den);
	        num %= den;
	        if (num == 0)
	            return (negative)? "-" + ret: ret;

	        ret = ret + ".";
	        Map<Long, Integer> map = new HashMap<>();
	        String temp = "";
	        int idx = 0;
	        while (num != 0 && !map.containsKey(num)) {
	            map.put(num, idx);
	            num *= 10;
	            temp = temp + (num / den);
	            num = num % den;
	            idx++;
	        }

	        if (num != 0) {
	        	String beforeLoop = temp.substring(0, map.get(num));
	            ret = ret + beforeLoop + "(" + temp.substring(map.get(num)) + ")";
	        } else {
	            ret = ret + temp;
	        }
	        if (negative) {
	            return "-" + ret;
	        }
	        return ret;        
    }
}