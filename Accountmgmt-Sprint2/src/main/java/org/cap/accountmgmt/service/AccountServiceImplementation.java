package org.cap.accountmgmt.service;

import java.util.List;
import java.util.Optional;

import org.cap.accountmgmt.dao.IAccountDao;
import org.cap.accountmgmt.entities.Account;
import org.cap.accountmgmt.exceptions.AccountNotFoundException;
import org.cap.accountmgmt.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class AccountServiceImplementation implements IAccountService {
	
   @Autowired
   private IAccountDao accountDao;
	
   public IAccountDao getAccountDao() {
	       return accountDao;
	    }

   @Autowired
   public void setaccountDao(IAccountDao dao) {
	      this.accountDao = dao;
	    }

   /**
   *
   * @param account
   * This method will validate account and add it to the database
   * @return account
   */
	@Override
	public String addAccount(Account account) {
		 if(account==null){
		  throw new InvalidArgumentException("Account can't be null");
	    }
		Account account1 = accountDao.save(account);
		return "Account Successfully Added";
    }


    /**
     *  This method will return list of all account
     * @return List of accounts
     */
	@Override
	public List<Account> fetchAllAccount() {
	List<Account> list = accountDao.findAll();
		return list;
	}

	
    /**
     * @param accountId
     *  This method will show account details by account id
     * @return account
     */
	@Override
	public Account showAccountDetails(String accountId) {
	Optional<Account>optional=accountDao.findById(accountId);
    if(optional.isPresent()){
		 Account account=optional.get();
		 return account;
		    }
    throw new AccountNotFoundException("account not found for id="+accountId);
    }
	

    /**
     *
     * @param accountId
     * This method will fetch the account by account id 
     * @return
     */
	@Override
	public Account findByAccountId(String accountId) {
	Optional<Account>optional=accountDao.findById(accountId);
    if(optional.isPresent()){
		 Account account=optional.get();
		 return account;
		    }
    throw new AccountNotFoundException("account not found for id="+accountId);
    }
    
	
	 /**
    *
    * @param accountId
    * This method will delete the account by account id 
    * @return
    */
	@Override
	public boolean deleteAccount(String accountId) {
		 Account account=findByAccountId(accountId);
		 accountDao.delete(account);
		 return true;
    }

	
	 /**
    *
    * @param 
    * This method will update the account by account id 
    * @return
    */
	@Override
	public Account updateAccount(String accountId, Account account) {
		Account account1=findByAccountId(accountId);
		accountDao.save(account1);
		return account1;
	}


    }
