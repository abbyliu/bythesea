package leecode.singlenumber;

public class Solution2 {
    public int singleNumber(int[] A) {
        if (A == null || A.length==0) return 0;
        int miss = 0;
        for (int value :A ) {
            miss = miss ^ value;
        }
        return miss;

    }
}