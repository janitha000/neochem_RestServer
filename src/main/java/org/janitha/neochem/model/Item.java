package org.janitha.neochem.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {
	private long id;
	private String ManeCode;
	private String ManeName;
	private String Type;
	private String FlavorFormat;
	private String FlavorType;
	private int Year;
	private String Country;
	private String NeoChemName;
    private String NeoChemCode;

	public Item(long id, String formerCode, String mname, String type, String fFormat, String FType, int year, String country, String neoName, String newCode) {

		this.id = id;
		this.ManeCode = formerCode;
		this.ManeName = mname;
		this.Type = type;
		this.FlavorFormat = fFormat;
		this.FlavorType = FType;
		this.Year = year;
		this.Country = country;
		this.NeoChemName = neoName;
		this.NeoChemCode = newCode;
	}

	public Item() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getManeCode() {
		return ManeCode;
	}

	public void setManeCode(String maneCode) {
		ManeCode = maneCode;
	}

	public String getManeName() {
		return ManeName;
	}

	public void setManeName(String maneName) {
		ManeName = maneName;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getFlavorFormat() {
		return FlavorFormat;
	}

	public void setFlavorFormat(String flavorFormat) {
		FlavorFormat = flavorFormat;
	}

	public String getFlavorType() {
		return FlavorType;
	}

	public void setFlavorType(String flavorType) {
		FlavorType = flavorType;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getNeoChemName() {
		return NeoChemName;
	}

	public void setNeoChemName(String neoChemName) {
		NeoChemName = neoChemName;
	}

	public String getNeoChemCode() {
		return NeoChemCode;
	}

	public void setNeoChemCode(String neoChemCode) {
		NeoChemCode = neoChemCode;
	}
	
	

}
