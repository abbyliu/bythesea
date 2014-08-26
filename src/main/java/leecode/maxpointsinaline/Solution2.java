package leecode.maxpointsinaline;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    static class Slope {
        double slope;
        public Slope(double sl) {
            slope = sl;
        }
        public int hashCode() {
           if (Double.compare(Double.NaN, slope) == 0) {
               return -1;
           } else {
               return (int)slope * 1000000;
           }
        }
        
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof Slope)) return false;
            Slope comp = (Slope) obj;
            if (Double.compare(Double.NaN, this.slope) == 0) {
                return Double.compare(Double.NaN, comp.slope) == 0;
            }
            return Math.abs(comp.slope - this.slope) < 0.00001d;
        }
    }
    private boolean isEqualsPoint(Point p1, Point p2) {
        return p1.x == p2.x && p1.y == p2.y;
    }
    private Slope getSlope(Point p1, Point p2) {
        if (p1.x == p2.x) {
            return new Slope(Double.NaN);
        } else {
            return new Slope((p2.y-p1.y)*1.0/(p2.x-p1.x));
        }
    }
    public int maxPoints(Point[] points) {
        if (points == null || points.length==0) return 0;
        int max = 1;
        
        for (int i = 0; i < points.length-1;i++) {
            int dup = 0;
            Map<Slope, Integer> counts = new HashMap<>();
            for (int j = i+1;j < points.length;j++) {
                if (isEqualsPoint(points[i],points[j])) {
                    dup++;continue;
                }
                Slope slope = getSlope(points[i],points[j]);
                if (counts.containsKey(slope)) {
                    counts.put(slope, counts.get(slope)+1);
                } else {
                    counts.put(slope, 2);
                }
            }
            
            for (Map.Entry<Slope, Integer> entry: counts.entrySet()) {
                if (entry.getValue() + dup > max) {
                    max = entry.getValue() + dup;
                }
            }
            if (dup+1 > max) max = dup+1;
        }
        return max;
   }
}