package leecode.majoritynumber;

public class Solution {
    public int majorityElement(int[] num) {
        int len = num.length;
        if (len <= 2) {
            return num[0];
        }
        return findNth(num, len/2 + 1 , 0, len-1);
    }
    
    private void switch1(int[] num, int  i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    private int findNth(int[] num, int pos, int start, int end) {
    	System.out.println(pos + " " +  start + " " + end);
        if (pos == 1) {
            return num[start];
        }
        int idx = start; 
        int value = num[start];
        switch1(num, end, start);
        int begin = start;
        while (begin < end) {
            if (num[begin] <= value) {
                switch1(num, idx, begin);
                idx++;
            }
            begin++;
        }
        switch1(num, end, idx);
        if (idx - start+1 == pos) {
            return num[idx];
        } else if (idx - start + 1 > pos) {
            return findNth(num, pos, start, idx-1);
        } else {
            return findNth(num, pos - (idx-start+1), idx+1, end);
        }
    }
    
    public static void main(String[] args) {
    	int[] input = new int[50000];
    	
    	for (int i = 0; i < input.length-1;i++) {
    		if (i < 24998) {
    			input[i] = 1;
    		} else {
    			input[i] = 2;
    		}
    	}
    	Solution s = new Solution();
    	System.out.println(s.majorityElement(input));
    }
}