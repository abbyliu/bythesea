package leecode.subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        if (num == null|| num.length==0) return Collections.emptyList();
        Arrays.sort(num);
        
        List<List<Integer>> ret = new ArrayList<>();
        int v = 1 << num.length;
        for (int i = 0; i < v; i++) {
            List<Integer> rett = new ArrayList<>();
            int value = i;
            boolean[] used = new boolean[num.length];
            int idx = 0;
            boolean skipped = false;
            while (value >0) {
                if ((value & 1) >0) {
                    if (idx > 0 && !used[idx-1] && num[idx-1] == num[idx]) {
                        skipped = true;
                        break;
                    } else {
                        rett.add(num[idx]);
                        used[idx] = true;
                    }
                }
                idx++;
                value = value >> 1;
            }
            if (!skipped) {
                ret.add(rett);
            }
        }
        return ret;
    }
}