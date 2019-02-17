package br.com.aimbra.inspection.arguments;

import java.time.LocalDate;

public class InspectionFileRequest {

	private String endYearInspect;
	private String endMouthYearInspect;
	private String cnpj;
	private String companyName;
	private String street;
	private String district;


	private String cep;
	private String city;
	private String uf;

	public String getEndYearInspect() {
		return endYearInspect;
	}

	public void setEndYearInspect(String endYearInspect) {
		this.endYearInspect = endYearInspect;
	}

	public String getEndMouthYearInspect() {
		return endMouthYearInspect;
	}

	public void setEndMouthYearInspect(String endMouthYearInspect) {
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
	
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Override
	public String toString() {
		return "InspectionFileRequest [endYearInspect=" + endYearInspect + ", endMouthYearInspect="
				+ endMouthYearInspect + ", cnpj=" + cnpj + ", companyName=" + companyName + ", street=" + street
				+ ", district=" + district + ", cep=" + cep + ", city=" + city + ", uf=" + uf + "]";
	}
	
	
	

}
