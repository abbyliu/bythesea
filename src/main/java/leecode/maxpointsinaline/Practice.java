package leecode.maxpointsinaline;

import java.util.HashMap;
import java.util.Map;

/*
 * Double(-0.0) != Double(0.0)
 * 
 */
public class Practice {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length == 1) return 1;
        
        int max = 0;
        
        Map<Slope2, Integer> maps = new HashMap<>();
        for (int i = 0; i < points.length-1; i++) {
           int duplicates = 0;
           maps.put(new Slope2(Double.NaN), 1);

           for (int j = i+1; j< points.length; j++){
              if (duplicateP(points[i], points[j])) {
                 duplicates ++; continue;
              }
              Slope2 slope = getSlope2(points[i],points[j]);
              if (maps.containsKey(slope)){
                  maps.put(slope, maps.get(slope)+1);
              } else {
                  maps.put(slope,2);
              }
           }
           for (Map.Entry<Slope2,Integer> entry: maps.entrySet()) {
               int v = entry.getValue() + duplicates;
               if ( v  > max) {
                  max = v;
               }
           }
           maps.clear();
        }
        return max;
    }

    Slope2 getSlope2(Point p1, Point p2) {
      if (p1.x == p2.x) {
        return new Slope2(Double.NaN);
      } else {
        double d = (double)(p2.y-p1.y)/(p2.x-p1.x);
        return new Slope2(d);
      }
    }

    boolean duplicateP(Point point1, Point point2) {
       return point1.x == point2.x && point1.y == point2.y;
    }    
    static class Slope2 {
        double slope;
        public Slope2(double d) {
          this.slope = d;
        }
        
        public boolean equals(Object o) {
          if ( o == this ) return true;
          if (! (o instanceof Slope2)) return false;
          Slope2 slope2 = (Slope2) o;
          
          if (Double.compare(Double.NaN, slope) == 0) {
            return Double.compare(Double.NaN, slope2.slope) == 0;
          }
          
          double mindiff = 0.00000000001d;
          return Math.abs(this.slope - slope2.slope) < mindiff;
        }
        public int hashCode() {
           if (Double.compare(Double.NaN, slope) == 0) {
              return 0;
           } else {
              return new Double(Math.abs(slope)).hashCode();
           }
        }
    }
    
    public static void main(String[] args) {
    	Practice p = new Practice();
    	Point[] points = new Point[] {new Point(2,3), new Point(3,3), new Point(-5,3)};
    	p.maxPoints(points);
/*    	System.out.println(Double.hashCode(-0.0));
    	System.out.println(Double.hashCode(0.0));
*/    }
}
