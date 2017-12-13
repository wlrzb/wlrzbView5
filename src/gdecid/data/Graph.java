package gdecid.data;

import gdecid.data.tuple.CompositeTupleSet;
import gdecid.visual.VisualItem;

public class Graph extends CompositeTupleSet {

	public static final String NODES
		= "data.graph.nodeGroup";
	public static final String EDGES
		= "data.graph.edgeGroup";
	public static final String DEFAULT_NODE_KEY
		= "data.graph.nodeKey";
	public static final String DEFAULT_SOURCE_KEY
		= "data.graph.sourceKey";
	public static final String DEFAULT_TARGET_KEY
		= "data.graph.targetKey";
	
	public Graph(Table nodes, Table edges, boolean directed) {
		this(nodes, edges, directed, DEFAULT_NODE_KEY, DEFAULT_SOURCE_KEY, DEFAULT_TARGET_KEY);
	}
	
	public Graph(Table nodes, Table edges, boolean directed, String sourceKey, String targetKey) {
		init(nodes, edges, directed, DEFAULT_NODE_KEY, sourceKey, targetKey);
	}
	
	public Graph(Table nodes, Table edges, boolean directed, String nodeKey, String sourceKey, String targetKey) {
		init(nodes, edges, directed, nodeKey, sourceKey, targetKey);
	}
	
	public void init(Table nodes, Table edges, boolean directed, String nodeKey, String sourceKey, String targetKey) {
		super.addSet(EDGES, edges);
		super.addSet(NODES, nodes);
	}
	
//	public VisualItem getSourceNode() {
//
//	}

	public VisualItem getTargetNode() {
		// TODO Auto-generated method stub
		return null;
	}

	public Table getNodeTable() {
		// TODO Auto-generated method stub
		return null;
	}

	public Table getEdgeTable() {
		// TODO Auto-generated method stub
		return null;
	}

}
