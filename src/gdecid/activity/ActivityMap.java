package gdecid.activity;

import java.util.HashMap;

public class ActivityMap {
	
	private HashMap m_map;
	private ActivityMap m_parent;
	
	public Activity put(String key, Activity activity) {
		return (Activity)m_map.put(key, activity);
	}
}
