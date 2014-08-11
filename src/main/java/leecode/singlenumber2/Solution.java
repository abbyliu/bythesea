package leecode.singlenumber2;

/*
 *  Given an array of integers, every element appears three times except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
 */
public class Solution {
	public int singleNumber(int A[]) {
	    int ones = 0, twos = 0, threes = 0;
	    for (int i = 0; i < A.length; i++) {
	        twos |= ones & A[i];
	        ones ^= A[i];
	        threes = ones & twos;
	        ones &= ~threes;
	        twos &= ~threes;
	    }
	    return ones;
	}
	
	public int singleNumber2(int[] A) {
		int ones = 0; int twos = 0; int threes = 0;
		for (int i = 0; i < A.length; i++) {
			twos = twos | (ones & A[i]);
			ones  = ones ^ A[i];
			threes = ones & twos;
			ones = ones & ~threes;
			twos = twos & ~threes;
		}
		return ones;
	}
}
