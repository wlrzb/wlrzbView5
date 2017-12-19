package gdecid.data.tuple;

import java.util.Iterator;

import gdecid.data.Graph;
import gdecid.data.Table;

public class TupleManager {
	
    protected Graph        m_graph;
    protected Table        m_table;
    protected Class        m_tupleType;
    
	private TableTuple[]   m_tuples;
	

    public TupleManager(Table t, Graph g, Class tupleType) {
        init(t, g, tupleType);
    }
    

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

    public Iterator iterator(IntIterator rows) {
        return new TupleManagerIterator(this, rows);
    }
	
	public class TupleManagerIterator implements Iterator {
		
		private TupleManager m_tuples;
		private Iterator  m_rows;
		
		public TupleManagerIterator(TupleManager tuples, Iterator rows) {
			m_tuples = tuples;
			m_rows   = rows;
		}
		
		public boolean hasNext() {
			return m_rows.hasNext();
	    }

	    public Object next() {
	        return m_tuples.getTuple((int)m_rows.next());
	    }
	}
}
