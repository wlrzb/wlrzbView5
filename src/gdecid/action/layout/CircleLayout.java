package gdecid.action.layout;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gdecid.visual.tuple.TableNodeItem;
import gdecid.visual.tuple.TableVisualItem;
import render.TupleSet;

public class CircleLayout{
	private double radius = 200; 
	
	public void run(TupleSet ts) {
               
        int nn = ts.getNodes().size();
		
		Iterator nodes = ts.getNodes().entrySet().iterator();
        for (int i=0; nodes.hasNext(); i++) {
            Map.Entry it = (Map.Entry)nodes.next();
            TableNodeItem tableNodeItem = (TableNodeItem) it.getValue();
            
            double angle = (2*Math.PI*i) / nn;
            double x = Math.cos(angle)*radius + 300;
            double y = Math.sin(angle)*radius + 300;
            
            tableNodeItem.setX(x);
            tableNodeItem.setY(y);
        }
	}
}
