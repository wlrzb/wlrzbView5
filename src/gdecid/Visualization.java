package gdecid;

import gdecid.visual.VisualGraph;
import gdecid.visual.VisualItem;
import gdecid.visual.VisualTable;
import gdecid.visual.VisualTupleSet;
import gdecid.data.tuple.TupleSet;
import gdecid.util.GdecidLib;

import java.util.LinkedHashMap;
import java.util.Map;

import gdecid.action.Action;
import gdecid.activity.ActivityMap;
import gdecid.data.Graph;
import gdecid.data.Schema;
import gdecid.data.Table;
import gdecid.data.expression.Predicate;

public class Visualization {
	
	private Map m_visual;
	private Map m_source;
	
	private ActivityMap m_actions;
	
	public Visualization() {
		m_visual = new LinkedHashMap();
		m_source = new LinkedHashMap();
	}
	
	public Table getTable(Graph graph) {
		return graph.getNodeTable();
	}

	public VisualTupleSet add(String group, TupleSet data) {
		return add(group, data, null);
	}
	
	public VisualTupleSet add(String group, TupleSet data, Predicate filter) {
		return addGraph(group, (Graph)data, filter);
	}

	public VisualGraph addGraph(String group, Graph graph, Predicate filter) {
		return addGraph(group, graph, filter, VisualItem.SCHEMA, VisualItem.SCHEMA);
	}
	
	public VisualGraph addGraph(String group, Graph graph, Predicate filter, Schema nodeSchema, Schema edgeSchema) {
		VisualTable nt, et;
		String ngroup = Graph.NODES;
		String egroup = Graph.EDGES;
		
		nt = addTable(ngroup, graph.getNodeTable(), filter, nodeSchema);
		et = addTable(egroup, graph.getEdgeTable(), filter, edgeSchema);
		
		VisualGraph vg = new VisualGraph(nt, et,
				graph.isDirected(),
				graph.getNodeKeyField(),
				graph.getEdgeSourceField(),
				graph.getEdgeTargetField());
		
        vg.setVisualization(this);
        vg.setGroup(group);
     
        addDataGroup(group, vg, graph);
		
		return vg;
	}
	
	public VisualTable addTable(String group, Table table, Predicate filter, Schema schema) {
		VisualTable vt = new VisualTable(table, this, group, filter, schema);
		addDataGroup(group, vt, table);
		return vt;
	}
	
	protected void addDataGroup(String group, VisualTupleSet ts, TupleSet src) {
		// private Map m_visual;
		m_visual.put(group, ts);
		// private Map m_source
		m_source.put(group, src);
	}
	
    public TupleSet getGroup(String group) {
        TupleSet ts = getVisualGroup(group);
        return ts;
    }
    
    public TupleSet getVisualGroup(String group) {
        return (TupleSet)m_visual.get(group);
    }
	
	public Action putAction(String name, Action action) {
		action.setVisualization(this);
		m_actions.put(name, action);
		return action;
	}
	
//    public Activity run(String action) {
//        return m_actions.run(action);
//    }
	
	
}
