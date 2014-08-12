package leecode.palindromenumber;
/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 * O(m)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome2(int x) {
		if (x <0 ) return false;
		
		int div = 1;
		while (x /div >=10) {
			div *=10;
		}
		
		while (x>0) {
			int right = x%10;
			int left = x/div;
			x = (x%div)/10;
			if (left != right) return false;
			div /=100;
		}
		
		return true;
	}
	   public boolean isPalindrome(int x) {
		   if (x < 0) return false;
		   int div = 1;
		   while ( x /div >=10) {
			   div = div * 10;
		   }
		   while (x != 0) {
			   int r = x %10;
			   int l = x /div;
			   if (l != r) return false;
			   x = (x % div)/ 10;
			   div = div/100;
		   }
		   return true;
	    }
}
