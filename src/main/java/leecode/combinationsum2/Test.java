package leecode.combinationsum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0|| target<= 0) return result;
        Arrays.sort(num);
        List<Integer> tmp = new ArrayList<>();
        boolean[] used = new boolean[num.length];
        findResult(num, used, 0, target, tmp, result);
        return result;
    }
    
    private void findResult(int[] num, boolean[] used, int idx, int target, List<Integer> tmp, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx ; i < num.length;i++) {
            if (num[i] > target) break;
            if (i > idx && !used[i-1] && num[i-1]== num[i]) {
                continue;
            }
            tmp.add(num[i]);
            used[i] = true;
            findResult(num, used, i+1, target- num[i], tmp, result);
            used[i] = false;
            tmp.remove(tmp.size()-1);
        }
    }
    public static void main(String[] args) {
    	Test t =new Test();
    	int[] num = {1,1,2,2 };
    	System.out.println(t.combinationSum2(num, 3));
    }
	
}
