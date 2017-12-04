package render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;

import gdecid.visual.tuple.TableVisualItem;

public class Display extends JComponent{
	
	TupleSet ts;
	
	EdgeRender edgeRender = new EdgeRender();
	
	public void Display() {
		setBackground(Color.WHITE);
		setSize(400,400); 		
	}
	
	public void add(TupleSet ts) {
		this.ts = ts;
	}
	
//    public void update(Graphics g) {
//        paint(g);
//    }
	
	public void paintComponent(Graphics g) {	
		Graphics2D g2D = (Graphics2D) g;
		paintDisplay(g2D);
	}
	
	public void paintDisplay(Graphics2D g2D) {
		LabelRender labelRender = new LabelRender();
		Iterator items = ts.getNodes().iterator();
		for (int i=0; items.hasNext(); i++) {
			TableVisualItem item = (TableVisualItem)items.next();
			labelRender.Render(g2D, item);
		}
	}

	
	

}
