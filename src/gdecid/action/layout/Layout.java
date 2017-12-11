package gdecid.action.layout;

import java.awt.geom.Point2D;

import prefuse.Display;

public class Layout {
	
    protected Point2D     m_anchor = null;
    
    protected Point2D     m_tmpa   = new Point2D.Double();
    
    public Point2D getLayoutAnchor() {
        if ( m_anchor != null )
            return m_anchor;
        
        m_tmpa.setLocation(0,0);
        
        Display d = m_vis.getDisplay(0);
        m_tmpa.setLocation(d.getWidth()/2.0,d.getHeight()/2.0);
        d.getInverseTransform().transform(m_tmpa, m_tmpa);
        
        return m_tmpa;
    }
}
