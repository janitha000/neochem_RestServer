package org.janitha.neochem.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemEntity {
	@Id
	private long id;
	private String formerCode;
	private String newCode;
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
