package br.com.aimbra.inspection.utils;

import br.com.aimbra.inspection.entities.FederateUnit;

public abstract class FederateUnitSelection {

	public static FederateUnit getFederateUnitInstance(String federateUnitForExtesion) {

		FederateUnit uf;

		switch (federateUnitForExtesion.toLowerCase()) {

		case "são paulo":
		case "sao paulo":
			uf = new FederateUnit();
			uf.setInitials("SP");
			if (federateUnitForExtesion.equals("sao paulo"))
				uf.setName(federateUnitForExtesion);
			else
				uf.setName(federateUnitForExtesion);
			break;

		case "rio de janeiro":
			uf = new FederateUnit();
			uf.setInitials("RJ");
			uf.setName(federateUnitForExtesion);
			break;
		
		case "espirito santos":
			uf = new FederateUnit();
			uf.setInitials("ES");
			uf.setName(federateUnitForExtesion);
			break;

		default:
			return null;
		}

		return uf;

	}

}
