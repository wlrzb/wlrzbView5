package gdecid.data;

import java.util.HashMap;

import gdecid.data.Table;
import gdecid.util.GdecidLib;

public class Schema {
	private String[] m_names;
	private Class[]  m_types;
	private Object[] m_dflts;
	private HashMap  m_lookup;
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
	
    public void addInterpolatedColumn(String name, Class type, Object dflt) {
        addColumn(name, type, dflt);
        addColumn(GdecidLib.getStartField(name), type, dflt);
        addColumn(GdecidLib.getEndField(name), type, dflt);
    }
	
    public void addInterpolatedColumn(String name, Class type) {
        addInterpolatedColumn(name, type, null);
    }
    
    

	public Table instantiate() {
		return instantiate(0);
	}
	
	public Table instantiate(int nrows) {
		Table t = new Table(nrows, m_size);
		for (int i=0; i<m_size; ++i) {
			t.addColumn(m_names[i], m_types[i], m_dflts[i]);
		}
		return t;
	}

	public int getColumnCount() {
		return m_size;
	}

	public Object getDefault(int col) {
		return m_dflts[col];
	}

	public Class getColumnType(int col) {
		return m_types[col];
	}
	
	public String getColumnName(int col) {
		return m_names[col];
	}
	
    public int getColumnIndex(String field) {
    	
        Integer idx = (Integer)m_lookup.get(field);
        return ( idx==null ? -1 : idx.intValue() );
    }
}
