package gdecid.data;

import gdecid.data.expression.Predicate;
import gdecid.data.util.ColumnProjection;

public class CascadedTable extends Table {
	
	protected Table      m_parent;
	
    protected CascadedTable(Table parent, Predicate rowFilter, 
            ColumnProjection colFilter, Class tupleType)
    {
        super(0, 0, tupleType);
        m_parent = parent;
    }
}
