package org.cap.accountmgmt.service;

import java.util.List;

import org.cap.accountmgmt.entities.Account;
import org.cap.accountmgmt.entities.Address;
import org.cap.accountmgmt.entities.Customer;

public interface IAccountService {
	
String addAccount(Customer customer, Address address, Account account);
boolean deleteAccount(String accountId);
Account showAccountDetails(String accountId);
Account findByAccountId(String accountId);
List<Account> fetchAllAccounts();
boolean updateCustomerName(String accountId, String customerName);
boolean updateCustomerContact(String accountId, String customerContact);
boolean updateCustomerAddress(String accountId, Address address);
String  addCustomerDetails(Customer customer, Address address);
}
 