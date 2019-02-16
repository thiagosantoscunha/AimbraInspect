package br.com.aimbra.inspection.arguments;

import java.time.LocalDate;

public class InspectionFileRequest {

	private LocalDate endYearInspect;
	private LocalDate endMouthYearInspect;
	private String cnpj;
	private String companyName;
	private String street;
	private String cep;
	private String city;
	private String uf;

	public LocalDate getEndYearInspect() {
		return endYearInspect;
	}

	public void setEndYearInspect(LocalDate endYearInspect) {
		this.endYearInspect = endYearInspect;
	}

	public LocalDate getEndMouthYearInspect() {
		return endMouthYearInspect;
	}

	public void setEndMouthYearInspect(LocalDate endMouthYearInspect) {
		this.endMouthYearInspect = endMouthYearInspect;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "InspectionFileRequest [endYearInspect=" + endYearInspect + ", endMouthYearInspect="
				+ endMouthYearInspect + ", cnpj=" + cnpj + ", companyName=" + companyName + ", street=" + street
				+ ", cep=" + cep + ", city=" + city + ", uf=" + uf + "]";
	}
	

}
