package br.com.aimbra.inspection.utils;

import java.util.InputMismatchException;

public class CnpjValidator {

	private String _cnpj;
	private int sm;
	private int rest;
	private int peso;
	private char digit;

	public CnpjValidator(String cnpj) {
		_cnpj = stringTratament(cnpj);
	}

	public boolean isCNPJ() {
		if (isCnpjFormat() || _cnpj == null) return false;
		try {
			return isCnpjValid();
		} catch (InputMismatchException erro) {
			return false;
		}
	}

	private boolean isCnpjValid() {
		return (calculateFirstDigit() == _cnpj.charAt(12)) && (calculateSecondDigit() == _cnpj.charAt(13));
	}
	
	private char calculateSecondDigit() {
		sm = 0;
		peso = 2;
		for (int i = 12; i >= 0; i--) {
			pesoVirified(i);
		}
		restTratament();
		return digit;
	}

	private void pesoVirified(int i) {
		sm += (convertStringToInt(i) * peso);
		peso += 1;
		if (peso == 10) peso = 2;
	}
	
	private String stringTratament(String cnpj) {
		if (cnpj == null) return null;
		return cnpj.trim().replace(".", "").replace("/", "").replace("-", "");
	}

	private void restTratament() {
		rest = sm % 11;
		if ((rest == 0) || (rest == 1)) digit = '0';
		else convertRestToChar();
	}

	private void convertRestToChar() {
		digit = (char) ((11 - rest) + 48);
	}

	private char calculateFirstDigit() {
		sm = 0;
		peso = 2;
		for (int i = 11; i >= 0; i--) {
			pesoVirified(i);
		}
		restTratament();
		return digit;
	}

	private int convertStringToInt(int i) {
		return (int) (_cnpj.charAt(i) - 48);
	}

	private boolean isCnpjFormat() {
		if (_cnpj == null) return false;
		return (_cnpj.equals("00000000000000") || _cnpj.equals("11111111111111") || _cnpj.equals("22222222222222")
				|| _cnpj.equals("33333333333333") || _cnpj.equals("44444444444444") || _cnpj.equals("55555555555555")
				|| _cnpj.equals("66666666666666") || _cnpj.equals("77777777777777") || _cnpj.equals("88888888888888")
				|| _cnpj.equals("99999999999999") || (_cnpj.length() != 14));
	}

	public String imprimeCNPJ() {
		return (_cnpj.substring(0, 2) + "." + _cnpj.substring(2, 5) + "." + _cnpj.substring(5, 8) + "."
				+ _cnpj.substring(8, 12) + "-" + _cnpj.substring(12, 14));
	}
}