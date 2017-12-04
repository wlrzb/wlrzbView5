package render;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;

import gdecid.visual.tuple.TableVisualItem;
import prefuse.visual.VisualItem;

public class LabelRender {
	
	String imageLoc;
	
	public void Render(Graphics2D g, TableVisualItem item) {
		String text = item.getName();
		Image  img  = getImage(item);
		double tx = item.getX();
		double ty = item.getY();
		drawString(g, text, tx, ty);
	}
	
	public void drawString(Graphics2D g, String text, double x, double y) {
		g.drawString(text, (float)x, (float)y);
	}
	
	public void drawImage(Graphics2D g) {
		g.drawImage(img, (int)ix, (int)iy, null);
	}
	
    protected Image getImage(VisualItem item) {

    }
	
}
