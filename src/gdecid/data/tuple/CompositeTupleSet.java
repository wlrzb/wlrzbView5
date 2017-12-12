package gdecid.data.tuple;

import java.util.Map;
import java.util.Set;

import gdecid.data.Table;

public class CompositeTupleSet {

	private Map m_map;
	private Set m_sets;
	
	public void addSet(String name, TupleSet set) {
		m_map.put(name, set);
		m_sets.add(set);
	}

}
