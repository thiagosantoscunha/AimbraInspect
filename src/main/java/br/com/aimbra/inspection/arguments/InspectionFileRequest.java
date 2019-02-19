package br.com.aimbra.inspection.arguments;

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
	
	public InspectionFileRequest(String line) {
		String[] fields = line.split(";");
		endYearInspect = fields[0];
		endMouthYearInspect = fields[1];
		cnpj = fields[2];
		companyName = fields[3];
		street = fields[4];
		cep = fields[5];
		district = fields[6];
		city = fields[7];
		uf = fields[8];
	}

	public String getEndYearInspect() {
		return endYearInspect;
	}

	public String getEndMouthYearInspect() {
		return endMouthYearInspect;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getStreet() {
		return street;
	}

	public String getCep() {
		return cep;
	}

	public String getCity() {
		return city;
	}

	public String getUf() {
		return uf;
	}
	
	public String getDistrict() {
		return district;
	}

	@Override
	public String toString() {
		return "InspectionFileRequest [endYearInspect=" + endYearInspect + ", endMouthYearInspect="
				+ endMouthYearInspect + ", cnpj=" + cnpj + ", companyName=" + companyName + ", street=" + street
				+ ", district=" + district + ", cep=" + cep + ", city=" + city + ", uf=" + uf + "]";
	}
	
	
	

}
