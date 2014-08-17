package eopi.c1;

public class IsPalindrome {
	public boolean isPalindrome(int x) {
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
}
