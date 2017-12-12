package gdecid.data;

import gdecid.data.Table;

public class Schema {
	private String[] m_names;
	private Class[]  m_types;
	private Object[] m_dflts;
	private int      m_size;
	
	public Schema() {
		this(10);
	}
	
	public Schema(int ncols) {
		m_names = new String[ncols];
		m_types = new Class[ncols];
		m_dflts = new Object[ncols];
		m_size = 0;
	}
	
    public void addColumn(String name, Class type) {
        addColumn(name, type, null);
    }
	
	public void addColumn(String name, Class type, Object defaultValue) {
		m_names[m_size] = name;
		m_types[m_size] = type;
		m_dflts[m_size] = defaultValue;
		m_size++;
	}

	public Table instantiate() {
		// TODO Auto-generated method stub
		return instantiate(0);
	}
	
	public Table instantiate(int nrows) {
		Table t = new Table(nrows, m_size);
		for (int i=0; i<m_size; ++i) {
			t.addColumn(m_names[i], m_types[i], m_dflts[i]);
		}
		return t;
	}
}
