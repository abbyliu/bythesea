package leecode.triangle;

import java.util.List;

public class Solution3 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        if (triangle.size() == 1 ) return triangle.get(0).get(0);
        
        int row = triangle.size();
        int[] buff = new int[row];
        for (int i = 0; i < buff.length;i++) {
            buff[i] = triangle.get(row-1).get(i);
        }
        int size = row;
        for (int i = 0; i < row-1; i++) {
            for (int j = 0; j < size-1; j++) {
                buff[j] = Math.min(buff[j],buff[j+1]) +
                     triangle.get(size-2).get(j);
            }
            size--;
        }
        return buff[0];
    }
}