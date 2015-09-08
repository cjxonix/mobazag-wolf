package startek.util;

import java.util.List;


public class StartekHelp {

	public static void createPageLinks(final List<String> pagelinks, int total,
			int rows, String baseurl, long category) {
		for (int i = 1; i <= total; i++) {
			pagelinks.add(baseurl + "/" + i + "/" + rows + "/" + category);
		}
	}

	public static String strFormat(int val, String formate) {
		String str = String.format("%03d", val);
		return str;
	}

	public static String strFormat(long val, String string) {
		String str = String.format("%03d", val);
		return str;
	}

}
