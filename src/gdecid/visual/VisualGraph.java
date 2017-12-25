package gdecid.visual;

import gdecid.Visualization;
import gdecid.data.Graph;
import gdecid.data.Table;

public class VisualGraph extends Graph implements VisualTupleSet {

    private Visualization m_vis;
    private String m_group;
	
    public VisualGraph(VisualTable nodes, VisualTable edges, boolean directed,
            String nodeKey, String sourceKey, String targetKey)
    {
        super(nodes, edges, directed, nodeKey, sourceKey, targetKey);
    }
    
    public void setVisualization(Visualization vis) {
        m_vis = vis;
    }
    
    public void setGroup(String group) {
        m_group = group;
    }
}
