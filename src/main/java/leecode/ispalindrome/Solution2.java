package leecode.ispalindrome;

public class Solution2 {
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        String trim = s.trim().toLowerCase();
        if (trim.length() <=1) return true;
        int start = 0;
        int end = trim.length()-1;
        while (start < end) {
            char first = trim.charAt(start);
            while (start < end && !isAlphNumber(first)) {
                start++;
                first = trim.charAt(start);
            }
            char second = trim.charAt(end);
            while (start < end && !isAlphNumber(second)) {
                end--;
                second = trim.charAt(end);
            }
            if (start >=end) return true;
            if (first != second) return false;
            start++;end--;
        }
        return true;
    }
    private boolean isAlphNumber(char c) {
        return (c>='a' && c<='z') ||
                (c>='0' && c<='9');
    }
        

}