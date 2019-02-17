package br.com.aimbra.inspection.main;

import java.time.LocalDate;
import java.util.Calendar;

import br.com.aimbra.inspection.controllers.InspectionController;
import br.com.aimbra.inspection.entities.City;
import br.com.aimbra.inspection.entities.Company;
import br.com.aimbra.inspection.entities.District;
import br.com.aimbra.inspection.entities.FederateUnit;
import br.com.aimbra.inspection.entities.Inspection;

public class Main {
	
	public static void main(String[] args) {
		
		FederateUnit uf = new FederateUnit();
		uf.setInitials("SP");
		uf.setName("São Paulo");
		
		City city = new City();
		city.setFederationUnit(uf);
		city.setName("Guarulhos");
		
		District district = new District();
		district.setCity(city);
		district.setName("Freguesia");
		
		
		Company company = new Company();
		company.setCnpj("00.000.000/0001-00");
		company.setName("Zero Company LTDA");
		company.setDistrict(district);
		company.setCity(city);
		company.setFederateUnit(uf);
		company.setStreet("Rua alenxandrio, 123");
		company.setZipCode("00000-000");
		
		Inspection inspection = new Inspection();
		inspection.setDate(LocalDate.now());
		inspection.setNameCompany(company.getName());
		inspection.setPublicPlace(company.getStreet());
		inspection.setZipCode(company.getZipCode());
		inspection.setDistrict(district);
		inspection.setCity(city);
		inspection.setFederateUnit(uf);
		inspection.setCompany(company);
		
		InspectionController inspectionController = new InspectionController();
		inspection = inspectionController.create(inspection);
		
		System.out.println(inspection);
		
		System.exit(0);
	}

}
