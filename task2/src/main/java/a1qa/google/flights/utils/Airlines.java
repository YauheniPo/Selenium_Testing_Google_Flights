package a1qa.google.flights.utils;

public enum Airlines {
	
	BELAVIA("Belavia");
	
	private String titleAirline;
	
	Airlines(String name) {
		this.titleAirline = name;
	}
	
	public String getTitle() {
		return titleAirline;
	}
}