package eopi.c1;

public class MultipleNoOper {
	public static int multipleNoOper(int x, int y) {
		int sum = 0;
		while (x >0) {
			if ( (x&1) >0) {
				sum = addNoOper(sum,y);
			}
			x >>=1;
			y <<=1;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int v = multipleNoOper(15,8);
		System.out.println(v);
		System.out.println(addNoOper(3,31));
	}
	
	public static int addNoOper(int a , int b) {
		int sum = 0; int carry = 0;
		int k = 1;
		int tempA = a; int tempB = b;
		while ( tempA > 0 || tempB>0) {
			int ak = a&k; 
			int bk = b&k;
			sum |= (ak^bk^carry);
			carry = (ak&bk) | (ak&carry)| (bk&carry);
			carry = carry<<1;
			k <<=1;
			tempA >>=1;
			tempB >>=1;
		}
		return sum|carry;
	}
}
