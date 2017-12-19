package gdecid.data.tuple;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import gdecid.data.Table;

public class CompositeTupleSet extends AbstractTupleSet {

	private Map m_map;
	private Set m_sets;
	
	protected CompositeTupleSet() {
		this(true);
	}
	
	protected CompositeTupleSet(boolean listen) {
		m_map  = new LinkedHashMap();
		m_sets = new HashSet();
	}
	
	public void addSet(String name, TupleSet set) {
		m_map.put(name, set);
		m_sets.add(set);
	}
	
    public TupleSet getSet(String name) {
        return (TupleSet)m_map.get(name);
    }

	@Override
	public int getTupleCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator tuples() {
		// TODO Auto-generated method stub
		return null;
	}

}
