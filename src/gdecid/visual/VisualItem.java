package gdecid.visual;

import java.awt.Graphics;

import gdecid.data.Schema;
import gdecid.data.Tuple;
import gdecid.util.GdecidLib;

public interface VisualItem extends Tuple {
	public void render(Graphics g);
	
	public void setX(double x);
	public void setStartX(double x);
	public void setEndX(double x);
	
	public void setY(double y);
	public void setStartY(double y);
	public void setEndY(double y);
	
	public double getX();
	public double getY();
	
	// ------------------------------------------------------------------------
    // VisualItem Base Schema
        
    /** The validated data field */
    public static final String VALIDATED
        = "_validated";
    /** The visible data field */
    public static final String VISIBLE
        = "_visible";
    /** The start visible data field */
    public static final String STARTVISIBLE
        = "_visible:start";
    /** The end visible data field */
    public static final String ENDVISIBLE
        = "_visible:end";
    /** The interactive data field */
    public static final String INTERACTIVE
        = "_interactive";
    /** The expanded data field */
    public static final String EXPANDED
        = "_expanded";
    /** The fixed data field */
    public static final String FIXED
        = "_fixed";
    /** The highlight data field */
    public static final String HIGHLIGHT
        = "_highlight";
    /** The hover data field */
    public static final String HOVER
        = "_hover";
    /** The x data field */
    public static final String X
        = "_x";
    /** The y data field */
    public static final String Y
        = "_y";
    /** The start x data field */
    public static final String STARTX
        = "_x:start";
    /** The start y data field */
    public static final String STARTY
        = "_y:start";
    /** The end x data field */
    public static final String ENDX
        = "_x:end";
    /** The end y data field */
    public static final String ENDY
        = "_y:end";
    /** The bounds data field */
    public static final String BOUNDS
        = "_bounds";
    /** The stroke color data field */
    public static final String STROKECOLOR
        = "_strokeColor";
    /** The start stroke color data field */
    public static final String STARTSTROKECOLOR
        = "_strokeColor:start";
    /** The end stroke color data field */
    public static final String ENDSTROKECOLOR
        = "_strokeColor:end";
    /** The fill color data field */
    public static final String FILLCOLOR
        = "_fillColor";
    /** The start fill color data field */
    public static final String STARTFILLCOLOR
        = "_fillColor:start";
    /** The end fill color data field */
    public static final String ENDFILLCOLOR
        = "fillColor:end";
    /** The text color data field */
    public static final String TEXTCOLOR
        = "_textColor";
    /** The start text color data field */
    public static final String STARTTEXTCOLOR
        = "_textColor:start";
    /** The end text color data field */
    public static final String ENDTEXTCOLOR
        = "_textColor:end";
    /** The size data field */
    public static final String SIZE
        = "_size";
    /** The start size data field */
    public static final String STARTSIZE
        = "_size:start";
    /** The end size data field */
    public static final String ENDSIZE
        = "size:end";
    /** The shape data field */
    public static final String SHAPE
        = "_shape";
    /** The stroke data field */
    public static final String STROKE
        = "_stroke";
    /** The font data field */
    public static final String FONT
        = "_font";
    /** The start font data field */
    public static final String STARTFONT
        = "_font:start";
    /** The end font data field */
    public static final String ENDFONT
        = "_font:end";
    /** The doi data field */
    public static final String DOI
        = "_doi";
    
    /** A permanent, locked copy of the base VisualItem schema */
    public static final Schema SCHEMA
        = GdecidLib.getVisualItemSchema();
    
    /** 
     *  The column index of the validated data field. This should be safe to do
     *  because a unique (non-inherited) validated field is required of all
     *  VisualItems, and should always be the first field included.
     */
//    public static final int IDX_VALIDATED 
//        = SCHEMA.getColumnIndex(VALIDATED);
    
    // ------------------------------------------------------------------------
    // VisualItem Extended Schema
    
    /** The label data field.
     * Not included in the VisualItem schema by default */
    public static final String LABEL
        = "label";
    /** The value data field.
     * Not included in the VisualItem schema by default */
    public static final String VALUE
        = "value";
    
    /** The polygon data field.
     * Not included in the VisualItem schema by default */
    public static final String POLYGON
        = "polygon";
    /** The start polygon data field.
     * Not included in the VisualItem schema by default */
    public static final String STARTPOLYGON
        = "polygon:start";
    /** The end polygon data field.
     * Not included in the VisualItem schema by default */
    public static final String ENDPOLYGON
        = "polygon:end";
    
    /** The x2 data field.
     * Not included in the VisualItem schema by default */
    public static final String X2
        = "x2";
    /** The y2 data field.
     * Not included in the VisualItem schema by default */
    public static final String Y2
        = "y2";
    /** The start x2 data field.
     * Not included in the VisualItem schema by default */
    public static final String STARTX2
        = "X2:start";
    /** The start y2 data field.
     * Not included in the VisualItem schema by default */
    public static final String STARTY2
        = "Y2:start";
    /** The end x2 data field.
     * Not included in the VisualItem schema by default */
    public static final String ENDX2
        = "X2:end";
    /** The end y2 data field.
     * Not included in the VisualItem schema by default */
    public static final String ENDY2
        = "Y2:end";
    
} // end of interface VisualItem
	
