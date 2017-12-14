package gdecid.data.column;

public interface Column {

	public Object get(int row);
	public void set(Object val, int row);

}
