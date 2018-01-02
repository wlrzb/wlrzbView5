package gdecid.util;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Stroke;
import java.awt.geom.Rectangle2D;

import gdecid.Constants;
import gdecid.data.Schema;
import gdecid.visual.VisualItem;

public class GdecidLib {
	
	
    public static String getStartField(String field) {
        return field+":start";
    }
    
    public static String getEndField(String field) {
        return field+":end";
    }
	
	public static Schema getVisualItemSchema() {
		
		Schema s = new Schema();
		
	    s.addColumn(VisualItem.VALIDATED, boolean.class, Boolean.FALSE);
        s.addColumn(VisualItem.VISIBLE, boolean.class, Boolean.TRUE);
        s.addColumn(VisualItem.STARTVISIBLE, boolean.class, Boolean.FALSE);
        s.addColumn(VisualItem.ENDVISIBLE, boolean.class, Boolean.TRUE);
        s.addColumn(VisualItem.INTERACTIVE, boolean.class, Boolean.TRUE);
        s.addColumn(VisualItem.EXPANDED, boolean.class, Boolean.TRUE);
        s.addColumn(VisualItem.FIXED, boolean.class, Boolean.FALSE);
        s.addColumn(VisualItem.HIGHLIGHT, boolean.class, Boolean.FALSE);
        s.addColumn(VisualItem.HOVER, boolean.class, Boolean.FALSE);
        
        s.addInterpolatedColumn(VisualItem.X, double.class);
        s.addInterpolatedColumn(VisualItem.Y, double.class);
        
        // bounding box
        s.addColumn(VisualItem.BOUNDS, Rectangle2D.class, new Rectangle2D.Double());
        
        // color
        Integer defStroke = new Integer(ColorLib.rgba(0,0,0,0));
        s.addInterpolatedColumn(VisualItem.STROKECOLOR, int.class, defStroke);

        Integer defFill = new Integer(ColorLib.rgba(0,0,0,0));
        s.addInterpolatedColumn(VisualItem.FILLCOLOR, int.class, defFill);

        Integer defTextColor = new Integer(ColorLib.rgba(0,0,0,0));
        s.addInterpolatedColumn(VisualItem.TEXTCOLOR, int.class, defTextColor);

        // size
        s.addInterpolatedColumn(VisualItem.SIZE, double.class, new Double(1));
        
        // shape
        s.addColumn(VisualItem.SHAPE, int.class,
            new Integer(Constants.SHAPE_RECTANGLE));
        
        // stroke
        s.addColumn(VisualItem.STROKE, Stroke.class, new BasicStroke());
        
        // font
        Font defFont = FontLib.getFont("SansSerif",Font.PLAIN,10);
        s.addInterpolatedColumn(VisualItem.FONT, Font.class, defFont);
        
        // degree-of-interest
        s.addColumn(VisualItem.DOI, double.class, new Double(Double.MIN_VALUE));

		return s;
	}
	
    public static void setX(VisualItem item, VisualItem referrer, double x) {
        double sx = item.getX();
        
        item.setStartX(sx);
        item.setEndX(x);
        item.setX(sx);
    }
    
    public static void setY(VisualItem item, VisualItem referrer, double y) {
        double sy = item.getY();

        item.setY(sy);
    }
}
