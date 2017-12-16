package gdecid.action;

import gdecid.Visualization;
import gdecid.activity.Activity;

public abstract class Action extends Activity {

    protected Visualization m_vis;
	
    public Action(Visualization vis) {
        this(vis, 0);
    }
    
    public Action(Visualization vis, long duration) {
        m_vis = vis;
    }
    
    public void setVisualization(Visualization vis) {
    	m_vis = vis;
    }
}
