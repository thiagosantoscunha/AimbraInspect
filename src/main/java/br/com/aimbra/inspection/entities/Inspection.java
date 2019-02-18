package br.com.aimbra.inspection.entities;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inspections")
public class Inspection implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "name_company", length = 150, nullable = false)
	private String nameCompany;

	@Column(name = "public_place", length = 150, nullable = false)
	private String publicPlace;

	@Column(name = "zip_code", length = 9, nullable = false)
	private String zipCode;
	
	@ManyToOne
	private District district;

	@ManyToOne
	private City city;

	@ManyToOne
	private FederateUnit federateUnit;
	
	@ManyToOne
	private Company company;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY));
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
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
	
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inspection other = (Inspection) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Inspection [id=" + id + ", date=" + date + ", nameCompany=" + nameCompany + ", publicPlace="
				+ publicPlace + ", zipCode=" + zipCode + ", district=" + district + ", city=" + city + ", federateUnit="
				+ federateUnit + ", company=" + company + "]";
	}

	
	
	

}
