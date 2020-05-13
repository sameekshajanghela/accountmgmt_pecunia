package com.capgemini.accountmgmt.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import com.capgemini.accountmgmt.entities.Address;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@Min(value = 6)
	private String customerId;

	@NotBlank(message = "Customername cannot be empty and only alphabets are allowed")
	private String customerName;

	@NotBlank(message = "All fields are required")
	private String customerAddress;

	@Min(value = 12)
	private String customerAadhar;

	@Min(value = 10)
	@NotBlank(message = "First five char should be an alphabet and next four should be digit and last should be an alphabet")
	private String customerPan;

	@Min(value = 10)
	private String customerContact;

	@NotBlank(message = "Male/Female fields are accepted")
	private String customerGender;

	@NotBlank(message = "Only valid dates are accepted")
	private Date customerDob;

	/**
	 *
	 * setters and getters
	 */
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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

	public String getCustomerAadhar() {
		return customerAadhar;
	}

	public void setCustomerAadhar(String customerAadhar) {
		this.customerAadhar = customerAadhar;
	}

	public String getCustomerPan() {
		return customerPan;
	}

	public void setCustomerPan(String customerPan) {
		this.customerPan = customerPan;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public Date getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(Date customerDob) {
		this.customerDob = customerDob;
	}

	/**
	 * default Non parametrized constructor
	 */
	public Customer() {
	}

	/**
	 * parametrized constructor
	 */
	public Customer(String customerId, String customerName, String customerAddress, String customerAadhar,
			String customerPan, String customerContact, String customerGender, Date customerDob) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerAadhar = customerAadhar;
		this.customerPan = customerPan;
		this.customerContact = customerContact;
		this.customerGender = customerGender;
		this.customerDob = customerDob;
	}

	/**
	 * override hashcode
	 * 
	 * @return hashcode
	 */
	@Override
	public int hashCode() {
		return customerId.hashCode();
	}

	/**
	 * check equality of account object
	 * 
	 * @param object
	 * @return
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null || !(object instanceof Customer))
			return false;
		Customer customer = (Customer) object;
		return this.customerId.equals(customer.getCustomerId());
	}

	/**
	 *
	 * @return combine details of account
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAadhar="
				+ customerAadhar + ", customerPan=" + customerPan + ", customerContact=" + customerContact
				+ ", customerGender=" + customerGender + ", customerDob=" + customerDob + "]";
	}

}
