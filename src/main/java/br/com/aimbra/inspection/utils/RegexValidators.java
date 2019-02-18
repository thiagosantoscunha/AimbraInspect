package br.com.aimbra.inspection.utils;

public abstract class RegexValidators {

	public static boolean isCnpj(String value) {
		return value.matches("([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})");
	}

	public static boolean isZipCode(String value, String region) {
		switch (region.toLowerCase()) {
		case "pt_br":
			return value.matches("^\\d{5}[-]\\d{3}$");
		default:
			System.out.println("Invalid Region");
		}
		return false;
	}

}
