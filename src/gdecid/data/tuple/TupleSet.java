package gdecid.data.tuple;

import java.util.Iterator;

public interface TupleSet {

	public void addColumn(String name, Class type);
	
	public void addColumn(String name, Class type, Object defaultValue);
	
    public int getTupleCount();
    
    public Iterator tuples();
}
