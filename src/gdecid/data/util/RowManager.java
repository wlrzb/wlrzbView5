package gdecid.data.util;

import java.util.Iterator;

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
    
    public Iterator rows() {
    	return new RowIterator();
    }
    
    public class RowIterator implements Iterator {
    	boolean reverse;
    	int last = -1, next;
    	
    	public RowIterator() {
    		next = m_firstid;
    	}

		public boolean hasNext() {
			return next <= m_curid;
		}

		public Object next() {
			last = next;
			next = ++next;
			return last;
		}
    	
    }
    
}
