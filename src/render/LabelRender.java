package render;

import java.awt.Graphics2D;
import java.awt.Shape;

import gdecid.visual.tuple.TableVisualItem;

public class LabelRender {
	
	public void Render(Graphics2D g, TableVisualItem item) {
		String text = item.getName();
		double x = item.getX();
		double y = item.getY();
		drawString(g, text, x, y);
	}
	
	public void drawString(Graphics2D g, String text, double x, double y) {
		g.drawString(text, (float)x, (float)y);
	}
	
}
