package com.SpringCRUDBySearch.SpringCRUDBySearch.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MobileStore {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String mobile_name;
	@Override
	public String toString() {
		return "MobileStore [id=" + id + ", mobile_name=" + mobile_name + ", mobile_company=" + mobile_company
				+ ", getId()=" + getId() + ", getMobile_name()=" + getMobile_name() + ", getMobile_company()="
				+ getMobile_company() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobile_name() {
		return mobile_name;
	}
	public void setMobile_name(String mobile_name) {
		this.mobile_name = mobile_name;
	}
	public String getMobile_company() {
		return mobile_company;
	}
	public void setMobile_company(String mobile_company) {
		this.mobile_company = mobile_company;
	}
	public String mobile_company;

}
