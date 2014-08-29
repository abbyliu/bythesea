package leecode.singlenumber2;

public class Solution2 {
    public int singleNumber(int[] A) {
        if (A == null || A.length ==0) return 0;
        int one = 0; int two = 0 ;int three = 0;
        for (int value: A) {
            two = two | (one& value);
            one = one ^ value;
            three = one & two;
            one = one & (~three);
            two = two & (~three);
        }
        return one;
   }
}