package leecode.numberof1s;

/* Number of 1 Bits */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int total = 0;
        while (n != 0) {
            if ((n & 1) !=0) {
                total++;
            }
            n = n >>> 1;
        }
        return total;
    }
}