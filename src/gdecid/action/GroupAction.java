package gdecid.action;

import gdecid.Visualization;

public abstract class GroupAction extends Action {
	
	protected String m_group;

    public GroupAction(String group) {
        this(null, group);
    }
    
    public GroupAction(Visualization vis, String group) {
        super(vis);
        m_group = group;
    }
}
