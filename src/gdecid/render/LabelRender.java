package gdecid.render;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.awt.image.BufferedImage;

import java.io.IOException;


import javax.imageio.ImageIO;
import gdecid.visual.tuple.TableVisualItem;

public class LabelRender {
	
	protected int m_imageMargin = 20;  // 图片与文字之间的空隙
	
	protected RectangularShape m_bbox  = new Rectangle2D.Double();
	protected Font  m_font;
	protected String m_text;
	
	private static Image img;
	
    public static final Graphics2D DEFAULT_GRAPHICS = (Graphics2D)
            new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics();
	
	
	static {
		try {
			img=ImageIO.read(LabelRender.class.getClassLoader().getResourceAsStream("images/ren30.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//URL imageURL = IOLib.urlFromString("images/ren.png"); 
		//img=Toolkit.getDefaultToolkit().createImage(imageURL);
	}
	
	AffineTransform m_transform = new AffineTransform();
	
	public void Render(Graphics2D g, TableVisualItem item) {
		String text = item.getText();
		double size = item.getSize(); // 获取图片的缩放倍数
		m_font = item.getFont();      // 获取文字的字体
		
		double tx = item.getX();
		double ty = item.getY();
		double ix = item.getX();
		double iy = item.getY();
		
		// 计算图片的高度和宽度，这里要用图片的原始高度乘图片的缩放倍数。
        double iw = size * img.getWidth(null);
        double ih = size * img.getHeight(null);
        
        ty = iy + ih + m_imageMargin;

        m_transform.setTransform(size, 0, 0, size, ix, iy);
        g.drawImage(img, m_transform, null);
        
        
        g.setFont(m_font);  // 设置画笔的字体
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g.drawString(text, (float)tx, (float)ty);
	}
	
	
	protected Shape getRawShape(TableVisualItem item) {
		m_text = item.getText();
		
		// 计算图片的尺寸
		double iw=0, ih=0;
		ih = img.getHeight(null);
		iw = img.getWidth(null);
		
		// 计算文字的尺寸
		int tw=0, th=0;
		m_font = item.getFont();
		//FontMetrics fm = DEFAULT_GRAPHICS.getFontMetrics(m_font);
		FontMetrics fm = new FontMetrics(m_font) { };
		th = fm.getHeight();
		tw = fm.stringWidth(m_text);
		
		double w=0, h=0;
		w = Math.max(iw, tw);
		h = ih + m_imageMargin + th;
		
		m_bbox.setFrame(item.getX(), item.getY(), w, h);
		return m_bbox;
	}
	
}
