package gdecid.visual;

import java.awt.Graphics;

import gdecid.data.Schema;
import gdecid.data.Tuple;
import gdecid.util.GdecidLib;

public interface VisualItem extends Tuple {
	public void render(Graphics g);
	
	public static final String VALIDATED = "validated";
	public static final String VISIBLE = "visible";
	public static final String X = "x";
	public static final String Y = "y";
	public static final String BOUNDS = "bounds";
	public static final String STROKECOLOR = "STROKECOLOR";
	public static final String FILLCOLOR = "FILLCOLOR";
	
	public static final Schema SCHEMA
		= GdecidLib.getVisualItemSchema();
}
