package com.staragile.financeme.financeme;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Financeme {

	@Id
	String accountId;
	String customerName;
	String customerAddress;
	String contactNumber;
	
	
	public Financeme() {
		super();
	}
	
	
	public Financeme(String accountId, String customerName, String customerAddress, String contactNumber) {
		super();
		this.accountId = accountId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.contactNumber = contactNumber;
	}
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String policyId) {
		this.accountId = policyId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
}
