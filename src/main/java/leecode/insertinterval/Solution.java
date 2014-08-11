package leecode.insertinterval;

import java.util.ArrayList;
import java.util.List;
/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

O(n)
 */
public class Solution {
	static class Node {
		public int v;
		public int t;

		public Node(int vv, int tt) {
			v = vv;
			t = tt;
		}
	}

	public List<Interval> insert3(List<Interval> intervals, Interval newInterval) {
		if (newInterval == null) return intervals;
		if (intervals == null || intervals.size() == 0) {
			List<Interval> ret = new ArrayList<>();
			ret.add(newInterval);
			return ret;
		}
		int min = 0;
		int max =0;
		Interval toInsert = newInterval;
		int i = 0;
		for (i = 0; i < intervals.size(); i++) {
			Interval in = intervals.get(i);
			if (in.end < toInsert.start) {
				continue;
			} else if (toInsert.end < in.start) {
				break;
			} else {
				min = Math.min(in.start, toInsert.start);
				max = Math.max(in.end, toInsert.end);
				toInsert = new Interval(min, max);
				intervals.remove(i);
				i--;
			}
		}
		intervals.add(i, toInsert);
		return intervals;
	}
	public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {

		int i;
		for (i = 0; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);

			if (curr.end < newInterval.start)
				continue;

			if (newInterval.end < curr.start)
				break;

			newInterval.start = Math.min(curr.start, newInterval.start);
			newInterval.end = Math.max(curr.end, newInterval.end);
			intervals.remove(i);
			i--;
		}
		intervals.add(i, newInterval);
		return intervals;
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<>();
		if (newInterval == null)
			return intervals;
		if (intervals == null || intervals.size() == 0) {
			result.add(newInterval);
			return result;
		}
		int i = 0;
		Node a = new Node(newInterval.start, 0);
		Node b = new Node(newInterval.end, 1);
		List<Node> nodes = new ArrayList<>();
		while (i < intervals.size()) {
			Interval ins = intervals.get(i);
			i++;
			nodes.add(new Node(ins.start, 0));
			nodes.add(new Node(ins.end, 1));
		}
		int start = 0;
		int end = nodes.size() - 1;
		int location = 0;
		boolean found = false;
		while (start < end) {
			int mid = (start + end) / 2;
			if (nodes.get(mid).v == newInterval.start) {
				found = true;
				location = mid;
				break;
			} else if (nodes.get(mid).v > newInterval.start) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		location = found ? location : start;
		if (newInterval.start <= nodes.get(location).v) {
			nodes.add(location, new Node(newInterval.start, 0));
		} else {
			nodes.add(location + 1, new Node(newInterval.start, 0));
		}

		start = 0;
		end = nodes.size() - 1;
		location = 0;
		found = false;
		while (start < end) {
			int mid = (start + end) / 2;
			if (nodes.get(mid).v == newInterval.end) {
				found = true;
				location = mid;
				break;
			} else if (nodes.get(mid).v > newInterval.end) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		location = found ? location : start;
		if (newInterval.end < nodes.get(location).v) {
			nodes.add(location, new Node(newInterval.end, 1));
		} else {
			nodes.add(location + 1, new Node(newInterval.end, 1));
		}

		start = 0;
		Interval intv = null;
		for (int ii = 0; ii < nodes.size(); ii++) {
			Node n = nodes.get(ii);
			if (n.t == 0) {
				start++;
				if (intv == null) {
					intv = new Interval();
					intv.start = n.v;
				}
			} else if (n.t == 1) {
				start--;
				if (start == 0) {
					intv.end = n.v;
					result.add(intv);
					intv = null;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 5));
		Solution s = new Solution();
		s.insert(intervals, new Interval(0, 1));
	}
}