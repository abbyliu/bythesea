package leecode.gas;

/* Gas Station */
/*
 * here are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
O(n), O(n)
 */
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