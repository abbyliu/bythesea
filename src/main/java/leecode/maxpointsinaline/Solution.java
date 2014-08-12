package leecode.maxpointsinaline;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

/*
 * Key takeaways
 * 1. HashMap, HashSet need to override both equals as well as hashCode
 * 2. Be careful comparing double, even for calculating hashCode
 * 3. Do not miss input validation!!
 * 4. understand your question first before dive into coding
 * O(n2)
 */

/*
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class Solution {
	
	
	static class Line {
		private double slope;
		private double offset;
		
		private static final double MINDIFF = 0.000000001d;
		
		public Line(double decline, double offset) {
			this.slope = decline;
			this.offset = offset;
		}
		
		@Override
		public int hashCode() {
			if (Double.compare(Double.NaN, slope) == 0) {
				return 0;
			}
			return (int)(slope * 1000000l);
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == this) {
				return true;
			}
			if (!( o instanceof Line)  ) {
				return false;
			}
			
			Line compare = (Line)o;
			if (Double.compare(Double.NaN, this.slope) == 0) {
				return Double.compare(Double.NaN, compare.slope) == 0
						&& Math.abs(compare.offset - this.offset) <= MINDIFF;
			} else {
				return Math.abs(compare.slope - this.slope) <= MINDIFF
				  && Math.abs(compare.offset - this.offset) <= MINDIFF;
			}
		}
	}

	static class Slope{
		Double slope;
		public Slope(Double d) {
			this.slope = d;
		}
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof Slope)) return false;
			
			Slope o1 = (Slope)o;
			if (Double.compare(slope,Double.NaN) == 0) {
				return Double.compare(o1.slope,Double.NaN) == 0;
			} else if (Double.compare(slope,Double.MIN_VALUE) == 0) {
				return  Double.compare(o1.slope,Double.MIN_VALUE) == 0;
			} else {
				return
						Math.abs((slope-o1.slope)) <= 0.0000001d;
			}
		}
		
		public int hashCode() {
			if (Double.compare(Double.NaN, slope) == 0) {
				return 0;
			}
			
			if (Double.compare(Double.MIN_VALUE, slope) == 0) {
				return 1;
			}
			return (int)(slope * 1000000l);
		
		}
	}
	public int maxPoints2(Point[] points) {
		if (points == null || points.length==0) return 0;
		
		int max = 1;
		Map<Slope, Integer> map = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			map.clear();
			map.put(new Slope(Double.MIN_VALUE), 1);
			int dup = 0;
			for (int j = i+1;j < points.length;j++) {
				if (points[i].x == points[j].x&& points[i].y == points[j].y) {
					dup++;
					continue;
				}
				double slope = points[i].x == points[j].x? Double.NaN:((double)(points[j].y-points[i].y))/(points[j].x-points[i].x);
				Slope s = new Slope(slope);
				if (map.get(s) == null) {
					map.put(s,2);
				} else {
					map.put(s, map.get(s)+1);
				}
			}
			for (Map.Entry<Slope, Integer> entry: map.entrySet()) {
				max = Math.max(max, dup + entry.getValue());
			}
		}
		return max;
	}
    public int maxPoints(Point[] points) {
    	if (points == null || points.length == 0) return 0;
    	if (points.length == 1) return 1;
    	if (points.length  == 2) return 2;
    	Map<Line, Set<Point>> linePointsMap = new HashMap<>();
    	for (int i = 0;i < points.length -1;i++)  {
    		for (int j = i+1; j < points.length; j++) {
    			Line line = getLine(points[i], points[j]);
    			Set<Point> sets = linePointsMap.get(line);
    			if (sets != null) {
    				sets.add(points[i]);
    				sets.add(points[j]);
    			} else {
    				sets = new HashSet<>();
    				sets.add(points[i]);sets.add(points[j]);
    				linePointsMap.put(line, sets);
    			}
    		}
    	}
    	int max = 0;
    	for (Map.Entry<Line, Set<Point>> entry: linePointsMap.entrySet()) {
    		if (entry.getValue().size() > max) {
    			max = entry.getValue().size();
    		}
    	}
        return max;
    }
    
    private Line getLine(Point p1, Point p2) {
    	if (p1.x == p2.x) {
    		return new Line(Double.NaN, p1.x);
    	} else {
    		double decline = (p2.y-p1.y)*1.0/(p2.x-p1.x);
    		double offset = p2.y - decline * p2.x;
    		return new Line(decline, offset);
    	}
    }
    
    public static void main(String args[]) {
//    	Point[] p = {new Point(560,248),new Point(0,16),new Point(30,250),new Point(950,187),new Point(630,277),new Point(950,187),new Point(-212,-268),new Point(-287,-222),new Point(53,37),new Point(-280,-100),new Point(-1,-14),new Point(-5,4),new Point(-35,-387),new Point(-95,11),new Point(-70,-13),new Point(-700,-274),new Point(-95,11),new Point(-2,-33),new Point(3,62),new Point(-4,-47),new Point(106,98),new Point(-7,-65),new Point(-8,-71),new Point(-8,-147),new Point(5,5),new Point(-5,-90),new Point(-420,-158),new Point(-420,-158),new Point(-350,-129),new Point(-475,-53),new Point(-4,-47),new Point(-380,-37),new Point(0,-24),new Point(35,299),new Point(-8,-71),new Point(-2,-6),new Point(8,25),new Point(6,13),new Point(-106,-146),new Point(53,37),new Point(-7,-128),new Point(-5,-1),new Point(-318,-390),new Point(-15,-191),new Point(-665,-85),new Point(318,342),new Point(7,138),new Point(-570,-69),new Point(-9,-4),new Point(0,-9),new Point(1,-7),new Point(-51,23),new Point(4,1),new Point(-7,5),new Point(-280,-100),new Point(700,306),new Point(0,-23),new Point(-7,-4),new Point(-246,-184),new Point(350,161),new Point(-424,-512),new Point(35,299),new Point(0,-24),new Point(-140,-42),new Point(-760,-101),new Point(-9,-9),new Point(140,74),new Point(-285,-21),new Point(-350,-129),new Point(-6,9),new Point(-630,-245),new Point(700,306),new Point(1,-17),new Point(0,16),new Point(-70,-13),new Point(1,24),new Point(-328,-260),new Point(-34,26),new Point(7,-5),new Point(-371,-451),new Point(-570,-69),new Point(0,27),new Point(-7,-65),new Point(-9,-166),new Point(-475,-53),new Point(-68,20),new Point(210,103),new Point(700,306),new Point(7,-6),new Point(-3,-52),new Point(-106,-146),new Point(560,248),new Point(10,6),new Point(6,119),new Point(0,2),new Point(-41,6),new Point(7,19),new Point(30,250)};
    	Point[] p = {new Point(4,0),new Point(4,-1),new Point(4,-5)};
    	Solution s = new Solution();
    	System.out.println(s.maxPoints2(p));
    }
}