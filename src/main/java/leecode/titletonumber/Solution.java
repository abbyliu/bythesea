package leecode.titletonumber;
/* Excel Sheet Column Number */
/* O(1) memory
 * O(s.length()) length
 */
public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        
        if (s == null || s.length() == 0) {
            return result;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            result = result * 26;
            result = result + (c - 'A'  + 1);
        }
        
        return result;
    }
}