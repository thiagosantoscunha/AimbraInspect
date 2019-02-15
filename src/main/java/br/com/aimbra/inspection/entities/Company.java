package br.com.aimbra.inspection.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "cnpj", length = 14, nullable = false, unique = true)
	private String cnpj;

	@Column(name = "name", length = 150, nullable = false, unique = true)
	private String name;

	@Column(name = "public_place", length = 150, nullable = false)
	private String publicPlace;

	@Column(name = "public_place", length = 8, nullable = false)
	private String zipCode;

	@ManyToOne
	private District district;

	@ManyToOne
	private City city;

	@ManyToOne
	private FederateUnit federateUnit;

	@OneToMany
	private List<Inspection> inspections;

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public FederateUnit getFederateUnit() {
		return federateUnit;
	}

	public void setFederateUnit(FederateUnit federateUnit) {
		this.federateUnit = federateUnit;
	}

	public List<Inspection> getInspections() {
		return inspections;
	}

	public void setInspections(List<Inspection> inspections) {
		this.inspections = inspections;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
