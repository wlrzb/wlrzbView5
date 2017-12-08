package render;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import gdecid.render.EdgeRenderer;
import gdecid.render.LabelRenderer;
import gdecid.visual.tuple.TableEdgeItem;
import gdecid.visual.tuple.TableNodeItem;
import gdecid.visual.tuple.TableVisualItem;

public class Display extends JComponent{
	
	TupleSet ts;
		
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
		LabelRenderer labelRenderer = new LabelRenderer();
		Iterator nodes = ts.getNodes().entrySet().iterator();
		for (int i=0; nodes.hasNext(); i++) {
            Map.Entry node = (Map.Entry)nodes.next();
            TableNodeItem tableNodeItem = (TableNodeItem) node.getValue();
			labelRenderer.Render(g2D, tableNodeItem);
		}
		
		EdgeRenderer edgeRenderer = new EdgeRenderer();
		Iterator edges = ts.getEdges().iterator();
		for (int i=0; edges.hasNext(); i++) {
            TableEdgeItem tableEdgeItem = (TableEdgeItem)edges.next();
			edgeRenderer.Render(g2D, tableEdgeItem, ts.getNodes());
		}
	}

	
	

}
