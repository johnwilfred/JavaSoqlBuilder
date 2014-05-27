package org.h2s.jw.main;

import org.h2s.jw.soql.annotation.SfColumn;
import org.h2s.jw.soql.annotation.SfObject;

/**
 * A sample domain class that has two custom annotation <BR>
 * - SfObject 
 * - SfColumn
 * 
 * SfObject maps to the equivalent salesforce object SfColumn maps to the
 * equivalent column of the selected salesforce object
 * 
 * @author johnwilfred
 * 
 */
@SfObject(name = "Account")
public class Company {

	@SfColumn(name = "id")
	private String id;

	@SfColumn(name = "name")
	private String companyName;

	@SfColumn(name = "billingCity")
	private String city;

	@SfColumn(name = "billingCountry")
	private String country;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Company() {
		super();
	}

	public Company(String id, String companyName, String city, String country) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.city = city;
		this.country = country;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
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
		Company other = (Company) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
