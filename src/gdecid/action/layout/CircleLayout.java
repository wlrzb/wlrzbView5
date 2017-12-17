package gdecid.action.layout;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gdecid.Visualization;
import gdecid.visual.tuple.TableNodeItem;
import gdecid.visual.tuple.TableVisualItem;
import gdecid.data.tuple.TupleSet;

public class CircleLayout extends Layout {
	private double radius = 200; 
	
	private String m_group;
	
    public CircleLayout(String group) {
        m_group = group;
    }
	
	public void run(Visualization m_vis) {
        
		TupleSet ts = m_vis.getGroup(m_group);
		
		int nn = ts.getTupleCount();
		
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
