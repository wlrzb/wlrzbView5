package gdecid.visual;

import gdecid.Visualization;
import gdecid.data.CascadedTable;
import gdecid.data.Schema;
import gdecid.data.Table;
import gdecid.data.expression.Predicate;
import gdecid.visual.tuple.TableVisualItem;

public class VisualTable extends CascadedTable implements VisualTupleSet {
	
    private Visualization m_vis;
    private String m_group;
	
    public VisualTable(Table parent, Visualization vis, String group, 
            Predicate rowFilter, Schema schema)
    {
        super(parent, rowFilter, null, TableVisualItem.class);
        init(vis, group, schema);
    }
    
    protected void init(Visualization vis, String group, Schema schema) {
        setVisualization(vis);
        setGroup(group);
        addColumns(schema);
    }
    
    public void setVisualization(Visualization vis) {
        m_vis = vis;
    }
    
    public void setGroup(String group) {
        m_group = group;
    }
    
    
    
}
