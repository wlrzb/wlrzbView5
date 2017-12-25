package gdecid.data.tuple;

import gdecid.data.Schema;
import gdecid.data.expression.Predicate;
import java.util.Iterator;

public abstract class AbstractTupleSet implements TupleSet{

    public Iterator tuples(Predicate filter) {
            return FilterIteratorFactory.tuples(this, filter);
    }
    
    public void addColumn(String name, Class type) {
        throw new UnsupportedOperationException();
    }
    
    public void addColumn(String name, Class type, Object defaultValue) {
        throw new UnsupportedOperationException();
    }
    
    public void addColumns(Schema schema) {
        for ( int i=0; i<schema.getColumnCount(); ++i ) {
            addColumn(schema.getColumnName(i), 
            		  schema.getColumnType(i), 
            		  schema.getDefault(i));
        } 
    }
    
    
}
