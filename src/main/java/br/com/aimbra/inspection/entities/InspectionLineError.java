package br.com.aimbra.inspection.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inspection_line_error")
public class InspectionLineError implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String endYearInspect;

	@Column
	private String endMouthYearInspect;

	@Column
	private String cnpj;

	@Column
	private String companyName;

	@Column
	private String street;

	@Column
	private String district;

	@Column
	private String cep;

	@Column
	private String city;

	@Column
	private String uf;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndYearInspect() {
		return endYearInspect;
	}

	public void setEndYearInspect(String endYearInspect) {
		this.endYearInspect = endYearInspect;
	}

	public String getEndMouthYearInspect() {
		return endMouthYearInspect;
	}

	public void setEndMouthYearInspect(String endMouthYearInspect) {
		this.endMouthYearInspect = endMouthYearInspect;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "InspectionLineError [id=" + id + ", endYearInspect=" + endYearInspect + ", endMouthYearInspect="
				+ endMouthYearInspect + ", cnpj=" + cnpj + ", companyName=" + companyName + ", street=" + street
				+ ", district=" + district + ", cep=" + cep + ", city=" + city + ", uf=" + uf + "]";
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
		InspectionLineError other = (InspectionLineError) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
