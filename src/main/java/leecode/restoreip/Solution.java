package leecode.restoreip;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter) 
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
    	List<String> result = new ArrayList<>();
    	if (s== null || s.length() < 4 || s.length() > 12) return result;
    	
    	result = findIPs(s, 4);
    	return result;
    }

	private List<String> findIPs(String s, int parts) {
		if (s.length() < parts || s.length() > parts * 3) return new ArrayList<String>();
		
		if (parts == 1) {
			int v = Integer.parseInt(s);
			List<String> res = new ArrayList<>();
			if (v > 255) return res;
			if (!s.equals(String.valueOf(v))) return res;
			res.add(s);
			return res;
		}
		List<String> newResult = new ArrayList<>();
		for (int i = 1; i < 4 && i < s.length(); i++) {
			String ip = s.substring(0, i);
			int v = Integer.parseInt(ip);
			if (v > 255) {
				continue;
			}
			if (!ip.equals(String.valueOf(v))) continue;
			String rest = s.substring(i);
			List<String> paths = findIPs(rest, parts -1);
			if (!paths.isEmpty()) {
				for (String ss: paths) {
					newResult.add(ip + "." + ss);
				}
			}
		}
		return newResult;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		s.restoreIpAddresses("0000");
	}
}
