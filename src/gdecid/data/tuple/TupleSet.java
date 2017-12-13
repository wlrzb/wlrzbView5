package gdecid.data.tuple;

public interface TupleSet {

	public void addColumn(String name, Class type);
	
	public void addColumn(String name, Class type, Object defaultValue);
}
