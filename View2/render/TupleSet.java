package render;

import java.util.ArrayList;
import java.util.List;

import gdecid.visual.tuple.TableVisualItem;

public class TupleSet {
	List<Object> Nodes;
	
	public void init() {
		Nodes = new ArrayList<Object>();
		Nodes.add(new TableVisualItem("北京"));
		Nodes.add(new TableVisualItem("上海"));
		Nodes.add(new TableVisualItem("广州"));
		Nodes.add(new TableVisualItem("深圳"));
		Nodes.add(new TableVisualItem("香港"));
	}

	public List<Object> getNodes() {
		return Nodes;
	}

	public void setNodes(List<Object> nodes) {
		Nodes = nodes;
	}


}
