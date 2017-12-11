package gdecid.data;

import java.util.ArrayList;

public class Table {
	
	protected ArrayList m_columns;
	protected ArrayList m_names;
	
	public table() {
		this(0, 0);
	}
	
	public table(int nrows, int ncols) {
		this(nrows, ncols, TableTuple.class);
	}
	
	public table(int nrows, int ncols, Class tupleType) {
		m_columns = new ArrayList(ncols);
		m_names   = new ArrayList(ncols);
	}
}
