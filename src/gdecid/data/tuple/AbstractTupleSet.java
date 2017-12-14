package gdecid.data.tuple;

import gdecid.data.Schema;

public abstract class AbstractTupleSet implements TupleSet{

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
