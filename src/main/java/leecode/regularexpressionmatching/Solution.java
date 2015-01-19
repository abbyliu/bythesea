package leecode.regularexpressionmatching;
/* Regular Expression Matching

 * implement regular expression matching with support for '.' and '*'.
 * O(M*N)
 */
public class Solution {
	
	
	public boolean isMatch(String s, String p) {
		if (s == null || p == null) return false;
		return isMatching(s,0,p,0);
	}
	
	private boolean isMatching(String s, int idx1, String p, int idx2) {
		int m = s.length();
		int n = p.length();
		if (idx2 == n) {
			return idx1 == m;
		}
		if (p.charAt(idx2) == '*') {
			return isMatching(s,idx1, p, idx2+1);
		}
		if (idx2 == n-1|| p.charAt(idx2+1) != '*') {
			if (idx1 == m || (p.charAt(idx2)!= '.' && p.charAt(idx2)!= s.charAt(idx1))) {
				return false;
			}
			return isMatching(s, idx1+1, p, idx2+1);
		} else {
			int i = -1;
			while (idx1+i < m &&(i<0||p.charAt(idx2)== '.'|| p.charAt(idx2)==s.charAt(idx1+i))) {
				if (isMatching(s, idx1+i+1, p, idx2+2)) {
					return true;
				}
				i++;
			}
			return false;
		}
 	}

}