package org.janitha.neochem.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {
	private long id;
	private String formerCode;
	private String newCode;

	public Item(long id, String formerCode, String newCode) {

		this.id = id;
		this.formerCode = formerCode;
		this.newCode = newCode;
	}

	public Item() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFormerCode() {
		return formerCode;
	}

	public void setFormerCode(String formerCode) {
		this.formerCode = formerCode;
	}

	public String getNewCode() {
		return newCode;
	}

	public void setNewCode(String newCode) {
		this.newCode = newCode;
	}

}
