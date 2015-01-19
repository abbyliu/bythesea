package leecode.greycode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* Gray Code
 * The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.
O(n expo)
 */
public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		s.grayCode(3);
	}
	public List<Integer> grayCode(int n) {
		if (n < 0) return Collections.emptyList();
		List<Integer> result = new ArrayList<>();
		result.add(0);
		for (int i = 0; i < n; i++) {
			int add = 1 << i;
			List<Integer> news = new ArrayList<>(result);
			for (int j = result.size()-1; j>=0;j--) {
				news.add(result.get(j)+add);
			}
			result = news;
		}
		return result;
	}

}