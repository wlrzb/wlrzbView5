package gdecid.data.util;

import gdecid.data.Table;

public class RowManager {
	
	protected Table m_table;
	private int m_curid = -1;
	private int m_firstid = 0;
	
	public RowManager(Table table) {
		m_table = table;
	}
	
	public int getMaximumRow() {
		return m_curid;
	}
	
	public int addRow() {
		int r;
		r = ++m_curid;
		return r;
	}

	public int getRowCount() {
		return 1 + m_curid - m_firstid;
	}
	
    public int getColumnRow(int row, int col) {
        return row;
    }
}
