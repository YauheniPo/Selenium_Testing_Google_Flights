package a1qa.framework.utils;

public enum TimeoutConfig {
	
	SPINNER(5000), MAX(30000), SLEEP(1000), MIN(500), SECONDS(10);

	private int timeout;

	private TimeoutConfig(int timeout) {
		this.timeout = timeout;
	}

	public int getTimeout() {
		return timeout;
	}
}