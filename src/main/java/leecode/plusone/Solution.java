package leecode.plusone;

/*
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
O(n)
 */
public class Solution {
	public int[] plusOne3(int[] digits) {
		if (digits == null || digits.length == 0) return digits;
		int idx = digits.length-1;
		boolean next = false;
		while (idx >= 0) { 
			int v = digits[idx]+1;
			if (v >=10) {
				next = true;
				digits[idx] = v%10;
				idx--;
			} else {
				digits[idx] = v;
				next = false;
				break;
			}
		}
		if (next) {
			int[] news = new int[digits.length+1];
			news[0] = 1;
			System.arraycopy(digits, 0, news, 1, digits.length);
			return news;
		} else {
			return digits;
		}
	}
    public int[] plusOne2(int[] digits) {
    	if (digits== null || digits.length == 0) return digits;
    	int idx = digits.length-1;
    	boolean next = false;
    	while (idx >=0) {
    		int v = digits[idx]+1;
    		if (v >= 10) {
    			idx--;
    			next = true;
    		} else {
    			next = false;
    			break;
    		}
    	}
    	int[] result = null;
    	int copy = 0;
    	if (next) {
    		result = new int[digits.length+1];
    		result[0] = 1;
    		copy = 1;
    	} else {
    		result = new int[digits.length];
    	}
    	int start = 0;
    	while (start < digits.length) {
    		if (start >= idx) {
    			result[copy++] = (1 + digits[start++]) %10;
    		} else {
    			result[copy++] = digits[start++];
    		}
    	}
    	return result;
    }
    public int[] plusOne(int[] digits) {
    	if (digits== null || digits.length == 0) return digits;
    	int idx = digits.length-1;
    	boolean next = false;
    	while (idx >=0) {
    		int v = 1^ digits[idx];
    		if (v == 0) {
    			idx--;
    			next = true;
    		} else {
    			next = false;
    			break;
    		}
    	}
    	int[] result = null;
    	int copy = 0;
    	if (next) {
    		result = new int[digits.length+1];
    		result[0] = 1;
    		copy = 1;
    	} else {
    		result = new int[digits.length];
    	}
    	int start = 0;
    	while (start < digits.length) {
    		if (start >= idx) {
    			result[copy++] = 1 ^ digits[start++];
    		} else {
    			result[copy++] = digits[start++];
    		}
    	}
    	return result;
    }
}