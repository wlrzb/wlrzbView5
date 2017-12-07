package gdecid.action.layout;

import java.util.Iterator;
import java.util.List;

import gdecid.visual.tuple.TableNodeItem;
import gdecid.visual.tuple.TableVisualItem;
import render.TupleSet;

public class CircleLayout{
	private double radius = 200; 
	
	public void run(TupleSet ts) {
        
        List<Object> Nodes = ts.getNodes();
        
        int nn = Nodes.size();
		
		Iterator items = Nodes.iterator();
        for (int i=0; items.hasNext(); i++) {
            TableNodeItem it = (TableNodeItem)items.next();
            double angle = (2*Math.PI*i) / nn;
            double x = Math.cos(angle)*radius + 300;
            double y = Math.sin(angle)*radius + 300;
            it.setX(x);
            it.setY(y);
        }
	}
}
