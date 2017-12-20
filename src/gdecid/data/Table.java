package gdecid.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import gdecid.data.column.Column;
import gdecid.data.column.ColumnFactory;
import gdecid.data.column.ColumnMetadata;
import gdecid.data.tuple.AbstractTupleSet;
import gdecid.data.tuple.TupleManager;
import gdecid.data.util.Index;
import gdecid.data.util.RowManager;


public class Table extends AbstractTupleSet{
	
	protected ArrayList m_columns;
	protected ArrayList m_names;
	
	protected HashMap m_entries;
	
	protected RowManager m_rows;
	
	protected TupleManager m_tuples;
	
	
	// 存储上一次操作的是哪一列数据
	protected int m_lastCol = -1;
	
	
	public Table() {
		this(0, 0);
	}
	
	
	public Table(int nrows, int ncols) {
		m_columns = new ArrayList(ncols);
		m_names   = new ArrayList(ncols);
		m_rows    = new RowManager(this);
		m_entries = new HashMap(ncols);
		m_tuples  = new TupleManager(this, null, null);
	}
	
	public void addColumn(String name, Class type, Object defaultValue) {
		Column col = ColumnFactory.getColumn(type, m_rows.getMaximumRow()+1, defaultValue);
		addColumn(name, col);
	}
	
	public void addColumn(String name, Column col) {
		m_columns.add(col);
		m_names.add(name);
		m_lastCol = m_columns.size()-1;
		m_entries.put(name, m_lastCol);
	}
	
	public void set(int row, String field, Object val) {
		int col = getColumnNumber(field);
		getColumn(col).set(val, row);
	}
	

//	private int getColumnNumber(String field) {
//		return (int) m_entries.get(field);
//	}
	
	private int getColumnNumber(String field) {
		if ( m_entries.get(field) == null )
			return -1;
		else 
			return (int) m_entries.get(field);
	}
	
    public int getColumnRow(int row, int col) {
        return m_rows.getColumnRow(row, col);
    }
	
	private Column getColumn(int col) {
		m_lastCol = col;
		return (Column)m_columns.get(col);
	}
	
    public int addRow() {
        int r = m_rows.addRow();
        updateRowCount();
               
        return r;
    }
    
    protected void updateRowCount() {
        int maxrow = m_rows.getMaximumRow() + 1;
        
        // update columns
        Iterator cols = getColumns();
        while ( cols.hasNext() ) {
            Column c = (Column)cols.next();
            c.setMaximumRow(maxrow);
        }
    }
    
    // 列迭代器，因为列是ArrayList存储，所以自动有Iterator
    protected Iterator getColumns() {
        return m_columns.iterator();
    }

	
	protected static class ColumnEntry {
		public int colum;
		public Column column;
		public ColumnMetadata metadata;
		public Index index;
		
		public ColumnEntry(int col, Column column, ColumnMetadata metadata) {
			this.colum = col;
			this.column = column;
		//	this.columnMetadata = metadata;
		}
		
	}
	
    public int getTupleCount() {
        return getRowCount();
    }
    
    public int getRowCount() {
        return m_rows.getRowCount();
    }
    
    public Iterator tuples() {
        return m_tuples.iterator();
    }
    
}
