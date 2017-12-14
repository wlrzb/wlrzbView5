package gdecid.data.column;

public class ObjectColumn extends AbstractColumn {
	
	private Object[] m_values;
	private int m_size;
	
	public ObjectColumn(Class type, int nrows, int capacity, Object defaultValue) {
		m_values = new Object[capacity];
        for ( int i=0; i<capacity; ++i ) {
            m_values[i] = defaultValue;
        }
		m_size = nrows;
	}
	
	public Object get(int row) {
		return m_values[row];
	}
	
	public void set(Object val, int row) {
		m_values[row] = val;
	}
	
}
