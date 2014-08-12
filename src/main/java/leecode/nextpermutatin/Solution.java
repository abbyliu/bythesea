package leecode.nextpermutatin;

import java.util.Arrays;
/*
 *  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 -> 1,3,2
3,2,1 -> 1,2,3
1,1,5 -> 1,5,1
O(n)
 */
public class Solution {

	public void nextPermutation3(int[] num) {
		if (num == null || num.length <=1) return ;
		int reversePoint = num.length-2;
		for (; reversePoint >=0; reversePoint--) {
			if (num[reversePoint] < num[reversePoint+1]) {
				break;
			}
		}
		if (reversePoint <= -1) {
			reverseArray(num, 0);
			return;
		}
		int nex = reversePoint + 1;
		int pi = 0;
		for (pi = reversePoint+2;pi < num.length; pi++) {
			if (num[pi] <= num[reversePoint]) {
				break;
			}
			if (num[pi] <= num[nex]) {
				nex = pi;
			}
		}
		int tmp = num[nex];
		num[nex] = num[reversePoint];
		num[reversePoint] = tmp;
		reverseArray(num, reversePoint+1);
	}
	
	
	private void reverseArray(int[] num, int i) {
		int start = i;
		int end = num.length-1;
		while (start < end) {
			int tmp = num[start];
			num[start] = num[end];
			num[end] = tmp;
			start++;
			end--;
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3};
		Solution so = new Solution();
		so.nextPermutation(num);
	}
	public void nextPermutation2(int[] num) {
		if (num == null || num.length <=1) return;
		int first = num.length-1;
		while (first >0) {
			if (num[first-1] < num[first]) {
				break;
			}
			first--;
		}
		if (first >0) {
			first--;
			int right = num.length-1;
			while (right >=0 && num[right] <= num[first]) {
				right--;
			}
			int swap = num[first];
			num[first] = num[right];
			num[right] = swap;
			first++;
		}
		int end = num.length -1;
		while (end > first) {
			int swap = num[end];
			num[end] = num[first];
			num[first] =swap;
			end --;
			first++;
		}
	}
	public void nextPermutation(int[] num) {
		if (num == null || num.length <=1) return;
		boolean swap = false;
		int idx = 0;
		int p = 0;
		for (int i = num.length-1; i > 0 ; i--) {
			for (int j = i-1; j>=0; j--) {
				if (num[i] > num[j]) {
					if ( j > idx || (j == idx && !swap)) {
						idx = j;
						p = i;
						swap = true;
					} 
				}
			}
		}
		if (!swap) {
			for (int i = 0; i < num.length /2 ; i++) {
				int tmp = num[i];
				num[i] = num[num.length -1 - i];
				num[num.length-1-i] = tmp;
			}
		} else {
			int tmp = num[idx];
			num[idx] = num[p];
			num[p] = tmp;
			Arrays.sort(num, idx+1 , num.length);
		}
	}
}
