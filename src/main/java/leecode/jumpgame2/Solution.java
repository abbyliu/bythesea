package leecode.jumpgame2;

/*
 * O(n)
 * O(1)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] A = {1,2,3};
		s.jump2(A);
	}

	public int jump2(int[] A) {
		if (A == null || A.length == 0) return 0;
		if (A.length ==1) return 0;
		int previousIndex = A[0];
		int previousV = 1;
		int currentIndex = 0;
		int currentV = 0;
		for (int i = 1 ; i < A.length; i++) {
			if (previousIndex < i) return 0;
			if (previousIndex >= A.length -1) return previousV;
			if (A[i] + i > currentIndex) {
				currentIndex = A[i] + i;
				currentV = previousV +1;
			}
			if (previousIndex == i) {
				previousIndex = currentIndex;
				previousV = currentV;
			}
		}
		return previousV;
	}
	
	public int jump(int[] A) {
		if (A == null || A.length <= 1)
			return 0;
		int ret = 0;
		int curr = 0;
		int last = 0;
		for (int i = 0; i < A.length; i++) {
			if (i > last) {
				last = curr;
				ret++;
			}
			curr= Math.max(curr, i + A[i]);
		}
		return ret;
	}

}
