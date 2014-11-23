package leecode.mergeintervals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import leecode.insertinterval.Interval;
/*
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]. 
O(nlogn0
 */
public class Solution {
	public static void main(String[] args) {
		CComparator c = new CComparator();
		System.out.println(c == null);
		String[] words = {"xyz1", "abc", "df"};
		Arrays.sort(words, (first, second) -> Integer.compare(first.length(), second.length()));
		System.out.println(Arrays.toString(words));
	}
	static class CComparator implements Comparator<Interval> {

		@Override
		public int compare(Interval o1, Interval o2) {
			
			return o1.start - o2.start;
		}
		
	}
	
	public List<Interval> merge2(List<Interval> intervals) {
		if (intervals == null || intervals.size()<=1) return intervals;
		Collections.sort(intervals, new CComparator());
		Interval in = intervals.get(0);
		for (int i = 1; i < intervals.size();i++) {
			Interval newI = intervals.get(i);
			if (in.end < newI.start) {
				in = newI;
			} else {
				in.end = Math.max(in.end, newI.end);
				intervals.remove(i);
				i--;
			}
		}
		return intervals;
	}
	
	
    public List<Interval> merge(List<Interval> intervals) {
    	if (intervals== null || intervals.size() < 2) return intervals;
    	int i = 0;
    	Collections.sort(intervals, new CComparator());
    	for (i = 0; i < intervals.size()-1; i++) {
    		Interval in = intervals.get(i);
    		Interval in2 = intervals.get(i+1);
    		if (in.end <  in2.start) {
    			continue;
    		}
    		int minStart = Math.min(in.start, in2.start);
    		int maxEnd = Math.max(in.end, in2.end);
    		Interval intv = new Interval(minStart, maxEnd);
    		intervals.set(i, intv);
    		intervals.remove(i+1);
    		i--;
    	}
    	
    	return intervals;
    }
}