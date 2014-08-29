package leecode.gas;

public class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length != cost.length || gas.length==0) return -1;
        int[] pure = new int[cost.length];
        for (int i = 0; i < gas.length;i++) {
            pure[i] = gas[i] - cost[i];
        }
        
        int idx = 0; int sum = 0;
        for (int i = 0 ;i < pure.length;i++) {
            sum += pure[i];
            if (sum < 0) {
                sum = 0;
                idx = i+1;
            }
        }
        if (idx == pure.length) return -1;
        
        for (int i = 0; i < idx; i++) {
            sum += pure[i];
            if (sum < 0) {
                return -1;
            }
        }
        return idx;
    }
}