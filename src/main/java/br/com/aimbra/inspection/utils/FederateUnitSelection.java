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
                uf.setName("São Paulo");
                return uf;

            case "rio de janeiro":
                uf = new FederateUnit();
                uf.setInitials("RJ");
                uf.setName("Rio de Janeiro");
                return uf;

            case "espirito santo":
                uf = new FederateUnit();
                uf.setInitials("ES");
                uf.setName("Espirito Santo");
                return uf;

            case "minas gerais":
                uf = new FederateUnit();
                uf.setInitials("MG");
                uf.setName("Minas Gerais");
                return uf;
                
            case "bahia":
                uf = new FederateUnit();
                uf.setInitials("BA");
                uf.setName("Bahia");
                return uf;
        }
        
		return null;
    }

}
