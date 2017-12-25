package gdecid.util;

import gdecid.data.Schema;
import gdecid.visual.VisualItem;

public class GdecidLib {
	public static Schema getVisualItemSchema() {
		Schema s = new Schema();
		s.addColumn(VisualItem.VALIDATED, boolean.class, Boolean.FALSE);
		return s;
	}
	
    public static void setX(VisualItem item, VisualItem referrer, double x) {
        double sx = item.getX();
        
        item.setX(sx);
    }
    
    public static void setY(VisualItem item, VisualItem referrer, double y) {
        double sy = item.getY();

        item.setY(sy);
    }
}
