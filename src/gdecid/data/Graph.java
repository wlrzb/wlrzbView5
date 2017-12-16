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
	
	protected String m_nkey;
	protected String m_skey;
	protected String m_tkey;
	protected boolean      m_directed = false;
	
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
		m_nkey = nodeKey;
		m_skey = sourceKey;
		m_tkey = targetKey;
	}
	
//	public VisualItem getSourceNode() {
//
//	}

	public VisualItem getTargetNode() {
		// TODO Auto-generated method stub
		return null;
	}

	public Table getNodeTable() {
		return (Table)getSet(NODES);
	}

    public Table getEdgeTable() {
        return (Table)getSet(EDGES);
    }

	public String getNodeKeyField() {
		return m_nkey;
	}

	public String getEdgeSourceField() {
		return m_skey;
	}
	
	public String getEdgeTargetField() {
		return m_tkey;
	}

	public boolean isDirected() {
		return m_directed;
	}

}
