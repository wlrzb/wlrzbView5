package gdecid.visual;

import gdecid.Visualization;
import gdecid.data.CascadedTable;
import gdecid.data.Schema;
import gdecid.data.Table;
import gdecid.data.expression.Predicate;
import gdecid.visual.tuple.TableVisualItem;

public class VisualTable extends CascadedTable {
	public VisualTable(Table parent, Visualization vis, String group, 
			Predicate rowFilter, Schema schema) {
		super(parent, rowFilter, null, TableVisualItem.class);
	}
}
