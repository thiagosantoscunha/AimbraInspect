package br.com.aimbra.inspection.arguments;

import br.com.aimbra.inspection.entities.City;
import br.com.aimbra.inspection.entities.FederateUnit;

public class CityRequest {

	private City city;
	private FederateUnit uf;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public FederateUnit getUf() {
		return uf;
	}

	public void setUf(FederateUnit uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "CityRequest [city=" + city + ", uf=" + uf + "]";
	}
	
	

}
