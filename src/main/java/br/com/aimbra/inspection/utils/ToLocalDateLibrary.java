package br.com.aimbra.inspection.utils;

import java.time.LocalDate;

public abstract class ToLocalDateLibrary {
	
	/**
	 *
	 * @param String dataString; Segue o padrão "mês/ano"
	 * @return LocalDate date;
	 */
	public static LocalDate StringToFirstDateOfMouth(String mountYear) {
		return LocalDate.of(
				Integer.parseInt(mountYear.split("/")[0]),
				Integer.parseInt(mountYear.split("/")[1]),
				1
			);
	}
	
}
