package leecode.plusone;

/* Plus One
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
O(n)
 */
public class Solution {
	public int[] plusOne(int[] digits) {
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
}