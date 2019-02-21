package br.com.aimbra.inspection.arguments;

import br.com.aimbra.inspection.utils.FederateUnitSelection;

public class FederateUnitRequest {

	private Long id;
	private String name;
	private String initials;

	
	public FederateUnitRequest(String name) {
		this.name = name;
	}

	public FederateUnitRequest(String name, String initials) {
		this.initials = initials;
		this.name = name;
	}

	public FederateUnitRequest(String name, String initials, Long id) {
		this.initials = initials;
		this.name = name;
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getInitials() {
		return initials;
	}

	@Override
	public String toString() {
		return "FederateUnitRequest [name=" + name + "]";
	}

}
