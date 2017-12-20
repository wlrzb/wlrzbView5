package gdecid.data.io;

import gdecid.data.Graph;
import gdecid.data.Schema;
import gdecid.data.Table;

public class GraphMLReader {
	
	protected Schema m_nsch = new Schema();
	protected Schema m_esch = new Schema();
	
	protected Graph m_graph = null;
	protected Table m_nodes;
	protected Table m_edges;
	
	protected String m_name;
	protected String m_type;
	protected String m_dflt;
	
	private boolean m_directed = false;
	
	private int m_row = -1;
	
	public Graph init() {
		addNodeSchema();
		addEdgeSchema();
		addColumn();
		loadData();
		m_graph = new Graph(m_nodes, m_edges, m_directed);
		return m_graph;
	}
	
	// 创建“Nodes”表结构
	protected void addNodeSchema() {
		//m_nsch.addColumn("身份证", String.class, null);
		m_nsch.addColumn("城市", String.class, null);
	}
	
	// 创建“Edges”表结构
	protected void addEdgeSchema() {
		m_esch.addColumn("主城市", String.class);
		m_esch.addColumn("对手城市", String.class);
	}
	
	// 根据表结构创建数据表
	protected void addColumn() {
		m_nodes = m_nsch.instantiate();
		m_edges = m_esch.instantiate();
	}
	
	// 载入数据
	protected void loadData() {
		loadNodesData();
		loadEdgesData();
	}
	
	protected void loadNodesData() {
		m_row = m_nodes.addRow();
		m_nodes.set(m_row, "城市", "北京");
		m_row = m_nodes.addRow();
		m_nodes.set(m_row, "城市", "上海");
		m_row = m_nodes.addRow();
		m_nodes.set(m_row, "城市", "广州");
		m_row = m_nodes.addRow();
		m_nodes.set(m_row, "城市", "深圳");
		m_row = m_nodes.addRow();
		m_nodes.set(m_row, "城市", "香港");
	}
	
	protected void loadEdgesData() {
		m_row = m_edges.addRow();
		m_edges.set(0, "主城市", "北京");
		m_edges.set(0, "对方城市", "上海");
		m_row = m_edges.addRow();
		m_edges.set(1, "主城市", "上海");
		m_edges.set(1, "对方城市", "广州");
		m_row = m_edges.addRow();
		m_edges.set(2, "主城市", "广州");
		m_edges.set(2, "对方城市", "深圳");
		m_row = m_edges.addRow();
		m_edges.set(3, "主城市", "深圳");
		m_edges.set(3, "对方城市", "香港");
		m_row = m_edges.addRow();
		m_edges.set(4, "主城市", "香港");
		m_edges.set(4, "对方城市", "北京");
	}
	
	
	
}
