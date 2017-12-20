package gdecid.data.column;

import java.lang.reflect.Method;
import java.util.Arrays;

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
	
    public void setMaximumRow(int nrows) {
        if ( nrows > m_values.length ) {
            int capacity = Math.max((3*m_values.length)/2 + 1, nrows);
            Object[] values = new Object[capacity];
            System.arraycopy(m_values, 0, values, 0, m_size);
            try {
                // since Object's clone method is protected, we default to
                // using reflection to create clones.
                Cloneable def = (Cloneable)m_defaultValue;
                Method m = def.getClass().getMethod("clone", (Class[])null);
                for ( int i=m_size; i<capacity; ++i ) {
                    values[i] = m.invoke(m_defaultValue, (Object[])null);
                }
            } catch ( Exception e ) {
                Arrays.fill(values, m_size, capacity, m_defaultValue);
            }
            m_values = values;
        }
        m_size = nrows;
    }
	
}
