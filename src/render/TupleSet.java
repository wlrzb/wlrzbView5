package render;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import gdecid.visual.tuple.TableEdgeItem;
import gdecid.visual.tuple.TableNodeItem;
import gdecid.visual.tuple.TableVisualItem;


public class TupleSet {
	
	private Map<String, Object> Nodes;
	private List<Object> Edges;
	
	public TupleSet() {
		NodesInit();
		EdgesInit();
	}
	
	private void NodesInit() {
		Nodes = new LinkedHashMap<String, Object>();
		Nodes.put("北京", new TableNodeItem("北京"));
		Nodes.put("上海", new TableNodeItem("上海"));
		Nodes.put("广州", new TableNodeItem("广州"));
		Nodes.put("深圳", new TableNodeItem("深圳"));
		Nodes.put("香港", new TableNodeItem("香港"));
	}
	
	private void EdgesInit() {
		Edges = new ArrayList<Object>();
		Edges.add(new TableEdgeItem("北京", "上海"));
		Edges.add(new TableEdgeItem("上海", "广州"));
		Edges.add(new TableEdgeItem("广州", "深圳"));
		Edges.add(new TableEdgeItem("深圳", "香港"));
		Edges.add(new TableEdgeItem("香港", "上海"));
	}


	public Map<String, Object> getNodes() {
		return Nodes;
	}

	public void setNodes(Map<String, Object> nodes) {
		Nodes = nodes;
	}

	public List<Object> getEdges() {
		return Edges;
	}

	public void setEdges(List<Object> edges) {
		Edges = edges;
	}
}
