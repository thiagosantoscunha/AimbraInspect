package br.com.aimbra.inspection.utils;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {
	

	@Override
	public Date convertToDatabaseColumn(LocalDate data) {
		return data != null ? Date.valueOf(data) : null;
	}
	
	@Override
	public LocalDate convertToEntityAttribute(Date data) {
		return data != null ? data.toLocalDate() : null;
		
	}
}