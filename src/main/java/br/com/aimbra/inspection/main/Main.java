package br.com.aimbra.inspection.main;

import br.com.aimbra.inspection.controllers.CityController;
import br.com.aimbra.inspection.entities.City;
import br.com.aimbra.inspection.entities.FederateUnit;

public class Main {
	
	public static void main(String[] args) {
		
		FederateUnit uf = new FederateUnit();
		uf.setInitials("SP");
		uf.setName("São Paulo");
		
		City city = new City();
		city.setFederationUnit(uf);
		city.setName("Guarulhos");
		
		CityController cityController = new CityController();
		city = cityController.create(city);
		
		System.out.println(city);
		
		System.exit(0);
	}

}
