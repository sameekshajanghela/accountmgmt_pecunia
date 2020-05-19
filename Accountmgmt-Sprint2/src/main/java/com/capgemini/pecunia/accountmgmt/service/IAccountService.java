package com.capgemini.pecunia.accountmgmt.service;

import java.util.List;
import com.capgemini.pecunia.accountmgmt.entities.Account;
import com.capgemini.pecunia.accountmgmt.entities.Address;
import com.capgemini.pecunia.accountmgmt.entities.Customer;

public interface IAccountService {

	String addAccount(Customer customer, Address address, Account account);

	boolean deleteAccount(String accountId);

	Account showAccountDetails(String accountId);

	Account findByAccountById(String accountId);

	String updateCustomerName(Account account, Customer customer);

    String updateCustomerContact(Account account, Customer customer);

<<<<<<< HEAD
=======
	Customer findByCustomerId(String customerId);
>>>>>>> 84a9eb32f7b102e3aeae08532c5de5c718f0e280
}
