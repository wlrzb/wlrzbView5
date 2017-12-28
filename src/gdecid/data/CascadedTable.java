package gdecid.data;

import java.util.Iterator;

import gdecid.data.expression.Predicate;
import gdecid.data.util.CascadedRowManager;
import gdecid.data.util.ColumnProjection;


public class CascadedTable extends Table {
	
    protected Table      m_parent;
	
    protected CascadedTable(Table parent, Predicate rowFilter, 
            ColumnProjection colFilter, Class tupleType)
    {
    	super(0, 0, tupleType);
        m_parent = parent;
        m_rows = parent.m_rows;
        setRowFilter();
    }
    
    public void setRowFilter() {
        filterRows();
    }

    private void filterRows() {
        Iterator ptuples = m_parent.tuples();
        while ( ptuples.hasNext() ) {
            Tuple pt = (Tuple)ptuples.next();
        }
    }
    
}
