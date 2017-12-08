package gdecid.visual.tuple;

import java.util.Map;

import gdecid.data.Graph;
import gdecid.visual.VisualItem;

public class TableEdgeItem {
	
	String SourceText;
	String TargetText;
	
	Graph m_graph;
	
	public TableEdgeItem(String SourceText, String TargetText) {
		m_graph = new Graph();
		this.SourceText = SourceText;
		this.TargetText = TargetText;
	}
	
	public VisualItem getSourceItem(Map<String, Object> Nodes) {
		return (TableNodeItem)Nodes.get(SourceText);
	}
	
	public VisualItem getTargetItem(Map<String, Object> Nodes) {
		return (TableNodeItem)Nodes.get(TargetText);
	}
}
