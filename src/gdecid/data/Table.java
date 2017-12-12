package gdecid.data;

import java.util.ArrayList;

import gdecid.data.column.Column;
import gdecid.data.column.ColumnFactory;
import gdecid.data.tuple.AbstractTupleSet;
import gdecid.data.util.RowManager;

public class Table extends AbstractTupleSet{
	
	protected ArrayList m_columns;
	protected ArrayList m_names;
	
	protected RowManager m_rows;
	
	public Table() {
		this(0, 0);
	}
	
	public Table(int nrows, int ncols) {
		this(nrows, ncols, TableTuple.class);
	}
	
	public Table(int nrows, int ncols, Class tupleType) {
		m_columns = new ArrayList(ncols);
		m_names   = new ArrayList(ncols);
		m_rows    = new RowManager(this);
	}
	
	public void addColumn(String name, Class type, Object defaultValue) {
		Column col = ColumnFactory.getColumn(type, m_rows.getMaximumRow()+1, defaultValue);
		addColumn(name, col);
	}
	
	public void addColumn(String name, Column col) {
		m_columns.add(col);
		m_names.add(name);
	}
}
