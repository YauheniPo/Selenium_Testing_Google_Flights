package context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
	
	private static ScenarioContext instance;
	private Map<String, Object> map;
	
	private ScenarioContext() {
		map = new HashMap<>();
	}

	public static synchronized ScenarioContext getInstance() {
		if (instance == null) {
			instance = new ScenarioContext();
		}
		return instance;
	}
	
	public void put(String key, Object value) {
		map.put(key, value);
	}
	
	public Object getValue(String key) {
		return map.get(key);
	}
	
	public static void setScenarioContextNull() {
		instance = null;
	}
}