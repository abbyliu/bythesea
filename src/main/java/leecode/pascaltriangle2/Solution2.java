package leecode.pascaltriangle2;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        if (rowIndex <0) return ret;
        for (int i =0; i <= rowIndex; i++) {
            ret.add(1);
        }
        for (int i = 0; i < rowIndex-1;i++) {
            for (int j = 0;j < i+1;j++) {
                int v = ret.get(i+1-j) + ret.get(i-j);
                ret.set(i+1-j, v);
            }
        }
        return ret;
    }        
}