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
	
	// ������Nodes����ṹ
	protected void addNodeSchema() {
		//m_nsch.addColumn("���֤", String.class, null);
		m_nsch.addColumn("����", String.class, null);
	}
	
	// ������Edges����ṹ
	protected void addEdgeSchema() {
		m_esch.addColumn("������", String.class);
		m_esch.addColumn("���ֳ���", String.class);
	}
	
	// ���ݱ�ṹ�������ݱ�
	protected void addColumn() {
		m_nodes = m_nsch.instantiate();
		m_edges = m_esch.instantiate();
	}
	
	// ��������
	protected void loadData() {
		loadNodesData();
		loadEdgesData();
	}
	
	protected void loadNodesData() {
		m_row = m_nodes.addRow();
		m_nodes.set(m_row, "����", "����");
		m_row = m_nodes.addRow();
		m_nodes.set(m_row, "����", "�Ϻ�");
		m_row = m_nodes.addRow();
		m_nodes.set(m_row, "����", "����");
		m_row = m_nodes.addRow();
		m_nodes.set(m_row, "����", "����");
		m_row = m_nodes.addRow();
		m_nodes.set(m_row, "����", "���");
	}
	
	protected void loadEdgesData() {
		m_row = m_edges.addRow();
		m_edges.set(0, "������", "����");
		m_edges.set(0, "�Է�����", "�Ϻ�");
		m_row = m_edges.addRow();
		m_edges.set(1, "������", "�Ϻ�");
		m_edges.set(1, "�Է�����", "����");
		m_row = m_edges.addRow();
		m_edges.set(2, "������", "����");
		m_edges.set(2, "�Է�����", "����");
		m_row = m_edges.addRow();
		m_edges.set(3, "������", "����");
		m_edges.set(3, "�Է�����", "���");
		m_row = m_edges.addRow();
		m_edges.set(4, "������", "���");
		m_edges.set(4, "�Է�����", "����");
	}
	
	
	
}
