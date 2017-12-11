package gdecid.data.io;

import gdecid.data.Graph;
import gdecid.data.Schema;

public class GraphMLReader {
	
	protected Schema m_nsch = new Schema();
	protected Schema m_esch = new Schema();
	
	protected Graph m_graph = null;
	protected Table m_nodes;
	protected Table m_edges;
	
	protected String m_name;
	protected String m_type;
	protected String m_dflt;
	
	public void init() {
		m_graph = new Graph(m_nodes, m_edges, m_directed);
	}
	
	// 创建“Nodes”表结构
	protected void addNodeSchema() {
		m_nsch.addColumn("身份证", String.class, null);
		m_nsch.addColumn("姓名", String.class, null);
	}
	
	// 创建“Edges”表结构
	protected void addEdgeSchema() {
		m_esch.addColumn("本人身份证号", String.class);
		m_esch.addColumn("对方身份证号", String.class);
	}
	
	protected void LoadData() {
		m_nodes = m_nsch.instantiate();
		m_edges = m_esch.instantiate();
	}
	
	
	
}
