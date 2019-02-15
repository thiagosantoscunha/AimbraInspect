package br.com.aimbra.inspection.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class City {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "password", nullable = false, length = 100)
	private String password;
	
	@ManyToOne
	private FederateUnit federationUnit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public FederateUnit getFederationUnit() {
		return federationUnit;
	}
	
	public void setFederationUnit(FederateUnit federationUnit) {
		this.federationUnit = federationUnit;
	}
	
}
