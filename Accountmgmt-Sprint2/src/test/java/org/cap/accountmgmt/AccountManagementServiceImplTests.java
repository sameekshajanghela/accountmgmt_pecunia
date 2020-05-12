
package org.cap.accountmgmt;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.constraints.Min;

import org.cap.accountmgmt.entities.Account;
import org.cap.accountmgmt.entities.Address;
import org.cap.accountmgmt.entities.Customer;
import org.cap.accountmgmt.exceptions.AccountNotFoundException;
import org.cap.accountmgmt.service.AccountServiceImplementation;
import org.cap.accountmgmt.service.IAccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest // for jpa tests
@ExtendWith(SpringExtension.class) // integrate spring test framework with junit5
//importing AccountServiceImplementation class as @DatajpaTest will only only search for repositories
@Import(AccountServiceImplementation.class)


class AccountManagementServiceImplTests {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private EntityManager entityManager;

/**
 * case when account does not exist in database before
 */
@Test
public void testAddAccount_1() {
    String accountId="200908199801";
    String customerId="123321";
    String addressId="090190";
    Account account = new Account();
    Customer customer = new Customer();
    Address address = new Address();
    account.setAccountId(accountId);
    customer.setCustomerId(customerId);
    address.setAddressId(addressId);
    String result = accountService.addAccount(customer, address, account);
    List<Account> fetched1 = entityManager.createQuery("from Account").getResultList();
    Assertions.assertEquals(1, fetched1.size());// verifying one got inserted
    Account expected1 = fetched1.get(0);
    List<Customer> fetched2 = entityManager.createQuery("from Customer").getResultList();
    Assertions.assertEquals(1, fetched2.size());// verifying one got inserted
    Customer expected2 = fetched2.get(0);
    List<Address> fetched3 = entityManager.createQuery("from Address").getResultList();
    Assertions.assertEquals(1, fetched3.size());// verifying one got inserted
    Address expected3 = fetched3.get(0);
    Assertions.assertEquals(expected1, result);// verifying fetch and stored are equal
    Assertions.assertEquals(accountId, expected1.getAccountId());
    Assertions.assertEquals(customerId, expected2.getCustomerId());
    Assertions.assertEquals(addressId, expected3.getAddressId());
}


/**
 * case when account doesn't exist , verifying AccountNotFoundException is thrown
 */
@Test
public void testFindByAccountId_1() {
    //Executable class is in Junit, don't choose the other one
    Executable executable = () -> accountService.findByAccountId("200908199801");
    Assertions.assertThrows(AccountNotFoundException.class, executable);
}

}