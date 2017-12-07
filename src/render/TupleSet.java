package render;

import java.util.ArrayList;
import java.util.List;

import gdecid.visual.tuple.TableNodeItem;
import gdecid.visual.tuple.TableVisualItem;

public class TupleSet {
	List<Object> Nodes;
	
	public void init() {
		Nodes = new ArrayList<Object>();
		Nodes.add(new TableNodeItem("北京"));
		Nodes.add(new TableNodeItem("上海"));
		Nodes.add(new TableNodeItem("广州"));
		Nodes.add(new TableNodeItem("深圳"));
		Nodes.add(new TableNodeItem("香港"));
	}

	public List<Object> getNodes() {
		return Nodes;
	}

	public void setNodes(List<Object> nodes) {
		Nodes = nodes;
	}


}
