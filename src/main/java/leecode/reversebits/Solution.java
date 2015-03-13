package leecode.reversebits;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (n == 0) return n;
        for (int i = 0; i <= 15; i++) {
            int p1 = getValueAt(n, i);
            int p2 = getValueAt(n, 31-i);
            if (p1 != p2) {
                n = setValueAt(i, p2, n);
                n = setValueAt(31-i, p1, n);
            }
        }
        
        return n;
    }
    
    private int getValueAt(int n, int pos)  {
        return  (1 << pos ) & n;
    }
    
    private int setValueAt(int pos, int value, int n) {
        int vv = 1 << pos;
        if (value == 0) {
            vv = ~vv;
            n = n & vv;
        } else {
            n = n | vv;
        }
        return n;
    }
}