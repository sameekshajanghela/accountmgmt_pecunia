package com.capgemini.accountmgmt.controller;

import java.util.Date;

import java.util.List;
import java.util.Map;
import com.capgemini.accountmgmt.util.AccountUtil;
import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolationException;
import com.capgemini.accountmgmt.entities.Account;
import com.capgemini.accountmgmt.entities.Address;
import com.capgemini.accountmgmt.entities.Customer;
import com.capgemini.accountmgmt.exceptions.AccountNotFoundException;
import com.capgemini.accountmgmt.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * @author Sameeksha Janghela
 */
@RequestMapping("/accounts")
@RestController
public class AccountRestController {
	/**
	 * Record the log in file
	 */
	private static final Logger Log = LoggerFactory.getLogger(AccountRestController.class);

	@Autowired
	private IAccountService accountService;

	@PostMapping("/add")
	public ResponseEntity<String> add(Map<String, Object> request){
        Account account = AccountUtil.convertToAccount(request);
        Customer customer = AccountUtil.convertToCustomer(request);
        Address address = AccountUtil.convertToAddress(request);
		String msg = accountService.addAccount(customer, address, account);
		ResponseEntity<String> response = new ResponseEntity<String>(msg, HttpStatus.OK);
		return response;
	}

	/**
	 * fetch account object by account id
	 * 
	 * @param accountId
	 * @return account and response to server
	 */
	@GetMapping("/showdetails/{accountId}")
	public ResponseEntity<Account> showAccountDetailsById(@PathVariable("accountId") String accountId) {
		Account account = accountService.showAccountDetails(accountId);
		ResponseEntity<Account> response = new ResponseEntity<>(account, HttpStatus.OK);
		return response;
	}

	/**
	 * fetch all the accounts from database
	 * 
	 * @return account list and response to server
	 */
	@GetMapping()
	public ResponseEntity<List<Account>> fetchAllAccounts() {
		List<Account> accountList = accountService.fetchAllAccounts();
		ResponseEntity<List<Account>> response = new ResponseEntity<>(accountList, HttpStatus.OK);
		return response;
	}

	/**
	 * set account status to be closed
	 * 
	 * @return
	 */
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAccount(@RequestBody Map<String, Object> request) {
		String msg = "";
		String accountId = (String) request.get("accountId");
		boolean isTrue = accountService.deleteAccount(accountId);
		if (isTrue) {
			msg = "Account Closed Successfully";
		} else {
			msg = "Account does not exist with Id" + accountId;
		}
		ResponseEntity<String> response = new ResponseEntity<String>(msg, HttpStatus.OK);
		return response;
	}

	/**
	 * this method will run when Account not found
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<String> handleAccountNotFound(AccountNotFoundException ex) {
		Log.error("Account not found exception ", ex);
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		return response;
	}

	/**
	 * this method will run when ConstraintViolationException occur
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handleConstraintViolate(ConstraintViolationException ex) {
		Log.error("constraint violation ", ex);
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		return response;
	}

	/**
	 * Blanket Exception Handler
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleAll(Throwable ex) {
		Log.error("Something went wrong ", ex);
		String msg = ex.getMessage();
		ResponseEntity<String> response = new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}

}
