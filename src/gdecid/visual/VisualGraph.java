package gdecid.visual;

import gdecid.data.Graph;
import gdecid.data.Table;

public class VisualGraph extends Graph implements VisualTupleSet {

    public VisualGraph(VisualTable nodes, VisualTable edges, boolean directed,
            String nodeKey, String sourceKey, String targetKey)
    {
        super(nodes, edges, directed, nodeKey, sourceKey, targetKey);
    }
}
