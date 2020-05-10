package org.cap.accountmgmt.service;

import java.util.List;
import java.util.Optional;

import org.cap.accountmgmt.dao.IAccountDao;
import org.cap.accountmgmt.dao.IAddressDao;
import org.cap.accountmgmt.dao.ICustomerDao;
import org.cap.accountmgmt.entities.Account;
import org.cap.accountmgmt.entities.Address;
import org.cap.accountmgmt.entities.Customer;
import org.cap.accountmgmt.exceptions.AccountNotFoundException;
import org.cap.accountmgmt.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/***
 * @author Sameeksha Janghela
 */

@Service
@Transactional

public class AccountServiceImplementation implements IAccountService {

	@Autowired
	private IAccountDao accountDao;

	@Autowired
	private ICustomerDao customerDao;

	@Autowired
	private IAddressDao addressDao;

	/**
	 *
	 * @param account This method will generate random customer id
	 * @return id
	 */
	public String generateCustomerId() {
		long count = customerDao.count();
		count++;
		String id = String.valueOf(count);
		String customerId = "customer-" + id;
		String sixDigitId = customerId.substring(0, 5);
		return id;

	}

	/**
	 *
	 * @param account This method will generate random address id
	 * @return id
	 */

	public String generateAddressId() {
		long count = addressDao.count();
		count++;
		String id = String.valueOf(count);
		String addressId = "address-" + id;
		String sixDigitId = addressId.substring(0, 5);
		return id;

	}

	/**
	 *
	 * @param account This method will generate random account id
	 * @return id
	 */

	public String generateAccountId() {
		long count = accountDao.count();
		count++;
		String id = String.valueOf(count);
		String accountId = "account-" + id;
		String twelveDigitId = accountId.substring(0, 11);
		return id;

	}

	/**
	 *
	 * @param account This method will validate account and add it to the database
	 * @return account
	 */
	@Override
	public String addAccount(Customer customer, Address address, Account account) {
		if (account == null) {
			throw new InvalidArgumentException("Account can't be null");
		}
		String customerId = generateCustomerId();
		customer.setCustomerId(customerId);
		customerDao.save(customer);
		String addressId = generateAddressId();
		address.setAddressId(customerId);
		addressDao.save(address);
		String accountId = generateAccountId();
		account.setAccountId(accountId);
		accountDao.save(account);
		return "Account Successfully Added";
	}

	/**
	 * @param accountId This method will show account details by account id
	 * @return account
	 */
	@Override
	public Account showAccountDetails(String accountId) {
		Account account = findByAccountId(accountId);
		return account;
	}

	/**
	 *
	 * @param accountId This method will fetch the account by account id
	 * @return
	 */
	@Override
	public Account findByAccountId(String accountId) {
		Optional<Account> optional = accountDao.findById(accountId);
		if (optional.isPresent()) {
			Account account = optional.get();
			return account;
		}
		throw new AccountNotFoundException("account not found for id=" + accountId);
	}

	/**
	 * This method will return list of all account
	 * 
	 * @return List of accounts
	 */
	@Override
	public List<Account> fetchAllAccounts() {
		List<Account> list = accountDao.findAll();
		return list;
	}

	/**
	 * -
	 * 
	 * @param accountId This method will delete the account by account id
	 * @return
	 */
	@Override
	public boolean deleteAccount(String accountId) {
		Account account = findByAccountId(accountId);
		account.setAccountStatus("Close");
		return true;
	}

	@Override
	public boolean updateCustomerName(Account account, Customer customer) {
	
		return false;
	}

	@Override
	public boolean updateCustomerContact(Account account, Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCustomerAddress(Account account, Address address) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String addCustomerDetails(Customer customer, Address address) {
		// TODO Auto-generated method stub
		return null;
	}

}
