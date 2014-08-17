package eopi.c1;

public class IntersectRectangle {
	static class Rectangle{
		int x,y;
		int width, height;
		public Rectangle(int xx, int yy, int ww, int hh) {
			x = xx;
			y = yy;
			width = ww;
			height = hh;
		}
	}
	
	public Rectangle intersectRectangle(Rectangle r, Rectangle s) {
		if (isIntersect(r,s)) {
			return new Rectangle(Math.max(r.x, s.x), Math.max(r.y, s.y),
					      Math.min(r.x+r.width, s.x + s.width) - Math.max(r.x, s.x),
					      Math.min(r.y+r.height, s.y+s.height) - Math.max(r.y, s.y)
					   );
		} else {
			return null;
		}
	}
	
	private boolean isIntersect(Rectangle r, Rectangle s) {
		return r.x <= s.x + s.width && r.x+ r.width >= s.x
			    && r.y <=s.y+s.height && r.y +r.height >= s.y;
	}
}
