package gdecid.render;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import gdecid.visual.tuple.TableVisualItem;

public class LabelRender {
	
	private static Image img;
	static {
		//img=ImageIO.read(LabelRender.class.getClassLoader().getResourceAsStream("images/ren.png"));
		URL imageURL = IOLib.urlFromString("images/ren.png"); 
		img=Toolkit.getDefaultToolkit().createImage(imageURL);
	}
	
	AffineTransform m_transform = new AffineTransform();
	
	public void Render(Graphics2D g, TableVisualItem item) {
		String text = item.getName();
		double tx = item.getX();
		double ty = item.getY();
		double ix = item.getX();
		double iy = item.getY();
		drawImage(g, img, ix, iy);
		//drawString(g, text, tx, ty);
		//g.drawImage(img, m_transform, (ImageObserver) this);
	}
	
	public void drawString(Graphics2D g, String text, double x, double y) {
		g.drawString(text, (float)x, (float)y);
	}
	
	public void drawImage(Graphics2D g, Image img, double ix, double iy) {
		g.drawImage(img, (int)ix, (int)iy, null);
	}
	
	
}
