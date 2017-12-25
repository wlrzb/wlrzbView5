package gdecid.action.layout;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gdecid.Visualization;
import gdecid.visual.VisualItem;
import gdecid.visual.VisualTable;
import gdecid.visual.tuple.TableNodeItem;
import gdecid.visual.tuple.TableVisualItem;
import gdecid.data.Table;
import gdecid.data.Tuple;
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
		
		Iterator items = ts.tuples();
        for (int i=0; items.hasNext(); i++) {
            Tuple n = (Tuple)items.next();
//            double angle = (2*Math.PI*i) / nn;
//            double x = Math.cos(angle)*radius + 300;
//            double y = Math.sin(angle)*radius + 300;
//            setX(n, null, x);
//            setY(n, null, y);
        }
	}
}
