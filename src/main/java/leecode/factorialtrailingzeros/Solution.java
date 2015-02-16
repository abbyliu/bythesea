package leecode.factorialtrailingzeros;
/* Factorial Trailing Zeroes */
/* O(log5(N)) */
public class Solution {
    public int trailingZeroes(int n) {
        int total = 0;
        for (int i = 5; n/i > 0; i = i * 5) {
            total += n/i;
        }
        return total;
    }
}
