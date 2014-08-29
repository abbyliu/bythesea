package leecode.pascaltriangle1;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows <=0) return ret;
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ret.add(first);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> newL = new ArrayList<>();
            newL.add(1);
            List<Integer> prev = ret.get(ret.size()-1);
            for (int j = 0; j < prev.size()-1;j++) {
                newL.add(prev.get(j) + prev.get(j+1));
            }
            newL.add(1);
            ret.add(newL);
        }
        return ret;
    }   
        
        
}