package gdecid.data.util;

import gdecid.data.Table;

public class RowManager {
	
	protected Table m_table;
	private int m_curid = -1;
	
	public RowManager(Table table) {
		m_table = table;
	}
	
	public int getMaximumRow() {
		return m_curid;
	}
}
