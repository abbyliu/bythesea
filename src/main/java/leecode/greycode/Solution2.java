package leecode.greycode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        if (n<0) return ret;
        ret.add(0);
        
        for (int i = 1 ; i <=n; i++) {
            List<Integer> newL = new ArrayList<>(ret);
            int add = 1 << (i-1);
            for (int j = ret.size()-1;j>=0;j--) {
                newL.add(ret.get(j)+add);
            }
            ret = newL;
        }
        return ret;
    }
}