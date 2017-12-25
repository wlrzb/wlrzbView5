package gdecid.action.layout;

import java.awt.geom.Point2D;

import gdecid.Display;
import gdecid.action.GroupAction;
import gdecid.util.GdecidLib;
import gdecid.visual.VisualItem;

public class Layout {
	
    protected Point2D     m_anchor = null;
    
    protected Point2D     m_tmpa   = new Point2D.Double();
    
//    public Layout(String group) {
//        super(group);
//    }
    
    public Point2D getLayoutAnchor() {
        if ( m_anchor != null )
            return m_anchor;
        
        m_tmpa.setLocation(0,0);
        
        Display d = m_vis.getDisplay(0);
        m_tmpa.setLocation(d.getWidth()/2.0,d.getHeight()/2.0);
        d.getInverseTransform().transform(m_tmpa, m_tmpa);
        
        return m_tmpa;
    }
    
    public void setX(VisualItem item, VisualItem referrer, double x) {
        GdecidLib.setX(item, referrer, x);
    }
    
    public void setY(VisualItem item, VisualItem referrer, double y) {
        GdecidLib.setY(item, referrer, y);
    }
}
