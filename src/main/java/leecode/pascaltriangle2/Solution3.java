package leecode.pascaltriangle2;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        if (rowIndex < 0) {
            return ret;
        }
        for (int i =0; i <= rowIndex; i++) {
            ret.add(1);
        }
        for (int i = 0 ; i < rowIndex; i++) {
            ret.set(i+1, 1);
            for (int j = i; j>0;j--) {
                ret.set(j, ret.get(j) + ret.get(j-1));
            }
        }
        return ret;
    }
}
