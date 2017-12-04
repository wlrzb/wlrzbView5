package render;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class GraphicsLib {
	
    /** Indicates no intersection between shapes */
    public static final int NO_INTERSECTION = 0;
    /** Indicates intersection between shapes */
    public static final int COINCIDENT      = -1;
    /** Indicates two lines are parallel */
    public static final int PARALLEL        = -2;
	
    public static int intersectLineRectangle(Point2D a1, Point2D a2, Rectangle2D r, Point2D[] pts) {
        double a1x = a1.getX(), a1y = a1.getY();
        double a2x = a2.getX(), a2y = a2.getY();
        double mxx = r.getMaxX(), mxy = r.getMaxY();
        double mnx = r.getMinX(), mny = r.getMinY();
        
        if ( pts[0] == null ) pts[0] = new Point2D.Double();
        if ( pts[1] == null ) pts[1] = new Point2D.Double();
        
        int i = 0;
        if ( intersectLineLine(mnx,mny,mxx,mny,a1x,a1y,a2x,a2y,pts[i]) > 0 ) i++;
        if ( intersectLineLine(mxx,mny,mxx,mxy,a1x,a1y,a2x,a2y,pts[i]) > 0 ) i++;
        if ( i == 2 ) return i;
        if ( intersectLineLine(mxx,mxy,mnx,mxy,a1x,a1y,a2x,a2y,pts[i]) > 0 ) i++;
        if ( i == 2 ) return i;
        if ( intersectLineLine(mnx,mxy,mnx,mny,a1x,a1y,a2x,a2y,pts[i]) > 0 ) i++;
        return i;
    }
    
    public static int intersectLineLine(double a1x, double a1y, double a2x,
            double a2y, double b1x, double b1y, double b2x, double b2y, 
            Point2D intersect)
        {
            double ua_t = (b2x-b1x)*(a1y-b1y)-(b2y-b1y)*(a1x-b1x);
            double ub_t = (a2x-a1x)*(a1y-b1y)-(a2y-a1y)*(a1x-b1x);
            double u_b  = (b2y-b1y)*(a2x-a1x)-(b2x-b1x)*(a2y-a1y);

            if ( u_b != 0 ) {
                double ua = ua_t / u_b;
                double ub = ub_t / u_b;

                if ( 0 <= ua && ua <= 1 && 0 <= ub && ub <= 1 ) {
                    intersect.setLocation(a1x+ua*(a2x-a1x), a1y+ua*(a2y-a1y));
                    return 1;
                } else {
                    return NO_INTERSECTION;
                }
            } else {
                return ( ua_t == 0 || ub_t == 0 ? COINCIDENT : PARALLEL );
            }
        }
}
