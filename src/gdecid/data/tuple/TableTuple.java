package gdecid.data.tuple;

import gdecid.data.Table;
import gdecid.data.Tuple;

public class TableTuple implements Tuple{

	protected Table m_table;
	protected int m_row;
	
	protected void init(Table table, int row) {
		m_table = table;
		m_row = row;
	}
}
