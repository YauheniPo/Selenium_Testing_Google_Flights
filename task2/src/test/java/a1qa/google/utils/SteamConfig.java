package a1qa.google.utils;

import static a1qa.framework.utils.ConstantValue.*;

import java.io.File;
import java.nio.file.FileSystems;

import a1qa.framework.utils.ConfigReader;
import a1qa.google.entity.User;

public class SteamConfig {

	public static final String LOGIN = "YauheniPo";
	public static final String PASSWORD = "popovichev";
	public static final String TAG_P = "p";
	public static final String TAG_DIV = "div";
	public static final String TAG_A = "a";
	public static final String GAME_1 = "game1";
	public static final String GAME_2 = "game2";
	public static final String NAME = "name";
	public static final String DISCOUNT = "discount";
	public static final String PRICE = "price";
	public static final String TITLE_CURRENCY = "USD";
	public static final String CURRENCY_SIGN = "$";
	public static final String VALUE_WALLET = "0.00";

	public String NEW_PROFILE_NAME = new StringBuffer("EvgeniiPopovich").append((int) (Math.random() * 100 + 1))
			.toString();

	public static User user;

	public static User createUser() {
		user = new User();
		user.setLogin(LOGIN);
		user.setPassword(PASSWORD);
		return user;
	}

	public static final String LINUX_STEAM = "steam_latest.deb";
	public static final String WINDOWS_STEAM = "SteamSetup.exe";
	public static String pathToFile = FileSystems
			.getDefault().getPath(ConfigReader.getInstance().getProperties().getProperty(PROP_ARTIFACTS_FOLDER),
					File.separator, (SYSTEM_OC.equals(NAME_WINDOWS) ? WINDOWS_STEAM : LINUX_STEAM))
			.toAbsolutePath().toString();
}