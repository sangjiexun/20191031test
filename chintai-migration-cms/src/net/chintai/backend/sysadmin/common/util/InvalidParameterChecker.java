package net.chintai.backend.sysadmin.common.util;

import java.util.regex.Pattern;

public class InvalidParameterChecker {

	private static final String PATTERN = "(.*\\.|^|.*|\\[('|\"))(c|C)lass(\\.|('|\")]|\\[).*";
	private static final Pattern EXCLUDE = Pattern.compile(PATTERN);

	public static boolean judge(String p) {
		return EXCLUDE.matcher(p).find();
	}

}
