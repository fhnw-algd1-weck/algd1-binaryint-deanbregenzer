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




		return String.format("%8s", s).replace(" ", "0");
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

