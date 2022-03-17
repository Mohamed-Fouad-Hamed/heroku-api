package alf.api.utilites;

import java.nio.charset.StandardCharsets;

public class StringUtilites {
	public static String convertToUtf8(String text) {
		if (text.length() == 0)
			return text;
		byte[] byteText = text.getBytes(StandardCharsets.ISO_8859_1);
		String textConverted = new String(byteText, StandardCharsets.UTF_8);
		return textConverted;
	}
}
