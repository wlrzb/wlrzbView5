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
	
	// ������Nodes����ṹ
	protected void addNodeSchema() {
		m_nsch.addColumn("���֤", String.class, null);
		m_nsch.addColumn("����", String.class, null);
	}
	
	// ������Edges����ṹ
	protected void addEdgeSchema() {
		m_esch.addColumn("�������֤��", String.class);
		m_esch.addColumn("�Է����֤��", String.class);
	}
	
	protected void LoadData() {
		m_nodes = m_nsch.instantiate();
		m_edges = m_esch.instantiate();
	}
	
	
	
}
