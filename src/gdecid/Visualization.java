package gdecid;

import gdecid.visual.VisualItem;
import gdecid.visual.VisualTable;
import gdecid.visual.VisualTupleSet;
import gdecid.data.tuple.TupleSet;
import gdecid.util.GdecidLib;

import java.util.Map;

import gdecid.data.Graph;
import gdecid.data.Schema;
import gdecid.data.expression.Predicate;

public class Visualization {
	
	private Map m_source;
	
	public Visualization() {
		
	}

	public VisualTupleSet add(String group, TupleSet data) {
		return add(group, data, null);
	}
	
	public VisualTupleSet add(String group, TupleSet data, Predicate filter) {
		return addGraph(group, (Graph)data, filter);
	}

	public VisualGraph addGraph(String group, Graph data, Predicate filter) {
		return addGraph(group, graph, filter, VisualItem.SCHEMA, VisualItem.SCHEMA);
	}
	
	public VisualGraph addGraph(Graph graph, Schema nodeSchema, Schema edgeSchema) {
		VisualTable nt, et;
		String ngroup = Graph.NODES;
		String egroup = Graph.EDGES;
		
		nt = addTable(ngroup, graph.getNodeTable(), filter, nodeSchema);
		et = addTable(egroup, graph.getEdgeTable(), filter, edgeSchema);
		
//		VisualGraph vg = new VisualGraph(nt, et,
//				graph.getNodeKeyField(),
//				graph.getEdgeSourceField(),
//				graph.getEdgeTargetField());
//		vg.setVisualization(this);
	}
	
	
}
