package leecode.countandsay;

import java.util.ArrayList;
import java.util.List;
/* Count and Say
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string. 
O(really unknown, np?)
 */
public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String str = s.countAndSay(20);
		System.out.println(str + " :  " + str.length());
	}

    public String countAndSay(int n) {
    	if (n <= 0) return null;
    	if (n == 1) return "1";
    	List<String> previous = new ArrayList<>();
    	previous.add("1");
    	int idx = 1;
    	int nofpreivous = 0;
    	while (idx < n) {
    		idx++;
    		nofpreivous = 1;
    		String previousV = previous.get(0);
    		List<String> news = new ArrayList<>();
    		for (int i = 1; i < previous.size(); i++) {
    			String current = previous.get(i);
				if (previousV.equals(current)) {
					nofpreivous++;
				} else {
					news.add(nofpreivous+"");
					news.add(previousV);
					nofpreivous = 1;
					previousV = current;
				}
    		}
    		news.add(nofpreivous+"");
    		news.add(previousV);
    		previous = news;
    	}
    	StringBuilder builder = new StringBuilder();
    	for (String ss: previous) {
    		builder.append(ss);
    	}
    	return builder.toString();
    }
}
