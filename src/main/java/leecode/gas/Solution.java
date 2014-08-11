package leecode.gas;
/*
 * here are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
O(n), O(n)
 */
public class Solution {
	
    public int canCompleteCircuit3(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length==0
           || gas.length != cost.length) return -1;
        int[] runs = new int[gas.length];
        for (int i = 0; i < gas.length;i++) {
            runs[i] = gas[i] - cost[i];
        }
        
        int sum = 0;
        int start = 0;
        for (int i = 0;i < runs.length;i++) {
            sum = sum + runs[i];
            if (sum < 0) {
                sum = 0; 
                start = i+1;
            }
        }
        if (start == runs.length) return -1;
        for (int i = 0; i < start;i++) {
            sum = sum + runs[i];
            if (sum < 0) {
                return -1;
            }
        }
        return start;
    }
    
    
	public int canCompleteCircuit2(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length == 0|| cost.length == 0|| cost.length != gas.length) return -1;
		int[] avail = new int[cost.length];
		for (int i = 0; i < cost.length; i++) {
			avail[i] = gas[i] - cost[i];
		}
		
		int sum = 0;
		int startPoint = 0;
		for (int i = 0; i < avail.length;i++) {
			sum = sum+ avail[i];
			if (sum < 0) {
				if (i < avail.length-1) {
					startPoint = i+1;
					sum = 0;
				} else {
					return -1;
				}
			} 
		}
		if (startPoint != 0) {
			for (int i = 0; i < startPoint;i++) {
				sum = sum + avail[i];
				if (sum < 0) return -1;
			}
		}
		return startPoint;
	}
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length != cost.length) {
			return -1;
		}
		int[] usage = new int[gas.length];
		for (int i = 0; i < gas.length; i++) {
			usage[i] = gas[i] - cost[i];
		}
		
		int sum = 0; int start = -1;
		for (int i = 0, j = 0; j< usage.length ;j++ ) {
			sum +=usage[j];
			if (sum < 0) {
				i = j + 1;
				sum = 0;
			} else {
				start = i;
			}
		}
		if (start != -1) {
			int ix = start;sum = 0;
			for (int i = start; i < usage.length ; i++) {
				sum += usage[i];
				if (sum < 0) {
					ix = -1; 
					break;
				}
			}
			
			if (ix != -1) {
				for (int i = 0; i < start; i++) {
					sum+= usage[i];
					if (sum < 0) {
						ix = -1;
						break;
					}
				}
			}
			
			return ix;
		}
		return -1;
	}
}
