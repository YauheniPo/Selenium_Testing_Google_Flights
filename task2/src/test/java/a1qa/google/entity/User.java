package a1qa.google.entity;

public class User {
	
	private String login;
	private String profileName;
	private String newProfileName;
	private String password;
	private String cash;
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setCash(String cash) {
		this.cash = cash;
	}
	
	public String getCash() {
		return cash;
	}
	
	public void setNewProfileName(String newProfileName) {
		this.newProfileName = newProfileName;
	}
	
	public String getNewProfileName() {
		return newProfileName;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
}