package a1qa.framework.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExConfig {
	
	public static final String REG_EX_VALUE_INT = "[0-9]+";
	public static final String REG_EX_VALUE_DOUBLE = "([0-9])+.([0-9])+";
	public static final String REG_EX_UPPER_TEXT = "([A-Z])+";
	public static final String REG_EX_END_HREF = "([\\w.]*)?$";

	public static String getStrToRegEx(String str, String regx) {
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(str);
        matcher.find();
        return matcher.group();
	}
}