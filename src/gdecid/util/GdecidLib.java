package gdecid.util;

import gdecid.data.Schema;
import gdecid.visual.VisualItem;

public class GdecidLib {
	public static Schema getVisualItemSchema() {
		Schema s = new Schema();
		s.addColumn(VisualItem.VALIDATED, boolean.class, Boolean.FALSE);
		return s;
	}
}
