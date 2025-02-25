package ch.fhnw.algd1.converters.binary;

public class BinConverter {
	public static String toString(int x) {
		String s = "";
		boolean negativ = false;
		if (x < 0) {
			negativ = true;
			x = -x;
		}

		while (x > 0) {
			if (x % 2 == 0) {
				s = "0" + s;
				x /= 2;
			} else {
				s = "1" + s;
				x /= 2;
			}
		}

		s = String.format("%8s", s).replace(" ", "0");
		String ss = "";

		// Wenn die Zahl negativ ist, berechnen wir das Zweierkomplement
		if (negativ) {
			// 1. Invertiere alle Bits (Einerkomplement)
			char[] chars = s.toCharArray();
			for (int i = 0; i < chars.length; i++) {
				chars[i] = (chars[i] == '0') ? '1' : '0';
			}

			// 2. Addiere 1 zum Ergebnis (Zweierkomplement)
			for (int i = chars.length - 1; i >= 0; i--) {
				if (chars[i] == '0') {
					chars[i] = '1';
					break;
				} else {
					chars[i] = '0';
				}
			}

			// Rückgabe des Zweierkomplements als String
			s = new String(chars);
		}

		return s;
	}





	public static int fromString(String text) {
		int result = 0;
		if (text.length() == 8){
			if (text.charAt(0) == '1') {
				result -= ((int) Math.pow(2, text.length() - 1));
			}
			for (int i = 1; i < text.length(); i++) {
				if (text.charAt(i) == '1') {
					result += (int) Math.pow(2, text.length() - (i + 1));
				}
			}
		} else {
			System.out.println("nicht gültige Zahl");
		}
		return result;
	}
}

