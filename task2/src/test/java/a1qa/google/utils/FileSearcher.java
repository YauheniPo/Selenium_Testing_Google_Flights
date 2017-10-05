package a1qa.google.utils;

import java.io.File;

public class FileSearcher {

	public static boolean isFileAvailable(String path) {
		File file = new File(path);
		if (file.exists()) {
			file.delete();
			return true;
		} else {
			return false;
		}
	}
}