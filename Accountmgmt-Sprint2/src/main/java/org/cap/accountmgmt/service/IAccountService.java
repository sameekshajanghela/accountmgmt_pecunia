package org.cap.accountmgmt.service;

import java.util.List;

import org.cap.accountmgmt.entities.Account;

public interface IAccountService {
String addAccount(Account account);
boolean deleteAccount(String accountId);
List<Account> fetchAllAccount();
Account showAccountDetails(String accountId);
Account updateAccount(String accountId, Account account);
Account findByAccountId(String accountId);

}
 