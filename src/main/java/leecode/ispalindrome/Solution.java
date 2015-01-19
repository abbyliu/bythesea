package leecode.ispalindrome;
/* Valid Palindrome
 * Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
O(n), O(1)
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if ( s== null || s.length() <=1) {
            return true;
        }
        
        String lower = s.toLowerCase();
        int start = 0;
        int end = lower.length() -1;
        while (start < end) {
            char c = lower.charAt(start);
            while (!isAlphaNumeric(c) && start < end) {
                start++;
                c = lower.charAt(start);
            }
            char c2 = lower.charAt(end);
            while (!isAlphaNumeric(c2) && start < end) {
                end--;
                c2 = lower.charAt(end);
            }
            if (c != c2) {
                return false;
            }
            start++;
            end--;
        }
    
        return true;
    }
    
    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c<=  'z') || (c >='0' && c <='9');
    }
 }
