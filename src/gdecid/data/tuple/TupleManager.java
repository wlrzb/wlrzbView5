package gdecid.data.tuple;

import java.util.Iterator;

import gdecid.data.Graph;
import gdecid.data.Table;
import gdecid.data.Tuple;
import java.util.logging.Logger;

public class TupleManager {
	
    protected Graph        m_graph;
    protected Table        m_table;
    protected Class        m_tupleType;
    
    
    private TableTuple[] m_tuples;
	
    /**
     * Create a new TupleManager for the given Table.
     * @param t the data Table to generate Tuples for
     */
    public TupleManager(Table t, Graph g, Class tupleType) {
        init(t, g, tupleType);
    }
    
    /**
     * Initialize this TupleManager for use with a given Table.
     * @param t the data Table to generate Tuples for
     */
    public void init(Table t, Graph g, Class tupleType) {
        if ( m_table != null ) {
            throw new IllegalStateException(
                "This TupleManager has already been initialized");
        }
        m_table = t;
        m_graph = g;
        m_tupleType = tupleType;
        m_tuples = null;
    }	
	
    public Tuple getTuple(int row) {
        ensureTupleArray(row);
        if ( m_tuples[row] == null ) {
            return (m_tuples[row] = newTuple(row));
        } else {
            return m_tuples[row];
        }
    }
    
    private void ensureTupleArray(int row) {
        int nrows = Math.max(m_table.getRowCount(), row+1);
        if ( m_tuples == null ) {
            m_tuples = new TableTuple[nrows];
        }
    }
    
    protected TableTuple newTuple(int row) {
        try {
            TableTuple t = (TableTuple)m_tupleType.newInstance();
            t.init(m_table, m_graph, row);
            return t;
        } catch ( Exception e ) {
            Logger.getLogger(getClass().getName()).warning(
                e.getMessage()+"\n");
            return null;
        }
    }
	
    public Iterator iterator(Iterator rows) {
        return new TupleManagerIterator(this, rows);
    }

	
	public class TupleManagerIterator implements Iterator {
		
		private TupleManager m_tuples;
		private Iterator m_rows;
		private int position = 0;
		
		public TupleManagerIterator(TupleManager tuples, Iterator rows) {
			m_tuples = tuples;
			m_rows = rows;
		}
		
		public boolean hasNext() {
			return m_rows.hasNext();
	    }

	    public Object next() {
	    	return m_tuples.getTuple((int)m_rows.next());
	    }
	}
}
