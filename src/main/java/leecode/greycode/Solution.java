package leecode.greycode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
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
		s.grayCode2(3);
	}
	public List<Integer> grayCode3(int n) {
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
    public List<Integer> grayCode(int n) {
    	if (n == 0) {
    		List<Integer> result = new ArrayList<>();
    		result.add(0);
    		return result;
    	}
    	List<Integer> result = grayCode(n-1);
    	int add = 1 << (n-1);
    	List<Integer> tmp = new ArrayList<>(result);
    	for (int i = result.size() -1 ; i>=0; i--) {
    		tmp.add(add + result.get(i));
    	}
    	return tmp;
    }
    
    public List<Integer> grayCode2(int n) {
    	List<Integer> result = new ArrayList<>();
    	result.add(0);
    	for (int i = 0; i < n; i++ ) {
    		int move = 1 << i;
    		for (int j = result.size() -1; j>=0; j--) {
    			result.add(move + result.get(j));
    		}
    	}
    	return result;
    } 

}