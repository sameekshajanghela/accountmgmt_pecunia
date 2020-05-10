package org.cap.accountmgmt.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Account")
public class Account {
	@Min(value=12)
	private String accountId;
	private String accountHolderId;
	private String accountBranchId;
	private String accountType;
	private String accountStatus;
	private Double accountBalance;
	private Double accountInterest;
	@DateTimeFormat(pattern = "YYYY/MM/dd")
	private Date lastUpdated;
	
	 /**
     * default Non parametrized constructor
     */
	public Account() {
		
	}
	

	 /**
    * default parametrized constructor
    */

	public Account(String accountId, String accountHolderId, String accountBranchId, String accountType,
			String accountStatus, Double accountBalance, Double accountInterest, Date lastUpdated) {
		this.accountId = accountId;
		this.accountHolderId = accountHolderId;
		this.accountBranchId = accountBranchId;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
		this.accountInterest = accountInterest;
		this.lastUpdated = lastUpdated;
	}

	@Id
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountHolderId() {
		return accountHolderId;
	}
	public void setAccountHolderId(String accountHolderId) {
		this.accountHolderId = accountHolderId;
	}
	public String getAccountBranchId() {
		return accountBranchId;
	}
	public void setAccountBranchId(String accountBranchId) {
		this.accountBranchId = accountBranchId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Double getAccountInterest() {
		return accountInterest;
	}
	public void setAccountIntrest(Double accountInterest) {
		this.accountInterest = accountInterest;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}


    /**
     * override hashcode
     * @return hashcode
     */
	@Override
	public int hashCode() {     
    return accountId.hashCode();
    }
	
	

    /**
     *  check equality of account object
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || !(object instanceof Account)) return false;
        Account account = (Account) object;
        return this.accountId.equals(account.getAccountId());
    }

    /**
     *
     * @return combine details of account
     */
    @Override
   	public String toString() {
   		return "Account [accountId=" + accountId + ", accountHolderId=" + accountHolderId + ", accountBranchId="
   				+ accountBranchId + ", accountType=" + accountType + ", accountStatus=" + accountStatus
   				+ ", accountBalance=" + accountBalance + ", accountInterest=" + accountInterest + ", lastUpdated="
   				+ lastUpdated + "]";
   	}

}
