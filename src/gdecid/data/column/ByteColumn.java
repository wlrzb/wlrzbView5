package gdecid.data.column;

import java.util.Arrays;

public class ByteColumn {

	private byte[] m_values;
	private int    m_size;
	
	public ByteColumn() {
		this(0, 10, (byte)0);
	}
	
	public ByteColumn(int nrows, int capacity, byte defaultValue) {
		m_values = new byte[capacity];
		Arrays.fill(m_values, defaultValue);
		m_size = nrows;
	}
	
	public void set(Object val, int row) {
		if (val instanceof Number) {
			setInt(((Number)val).byteValue(), row);
		} else if (val instanceof String) {
			setString((String)val, row);
		}
	}
	
	private void setString(String val, int row) {
		m_values[row] = (byte)val;
		
	}

	public void setInt(int val, int row) {
		m_values[row] = (byte)val;
	}
}
