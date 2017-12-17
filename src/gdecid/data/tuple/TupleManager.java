package gdecid.data.tuple;

import java.util.Iterator;

import gdecid.data.Graph;
import gdecid.data.Table;

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
		return m_tuples[row];
	}

	
	public class TupleManagerIterator implements Iterator {
		
		private TupleManager m_tuples;
		private IntIterator  m_rows;
		
		public boolean hasNext() {
			return m_rows.hasNext();
	    }

	    public Object next() {
	        return m_tuples.getTuple(m_rows.nextInt());
	    }
	}
}
