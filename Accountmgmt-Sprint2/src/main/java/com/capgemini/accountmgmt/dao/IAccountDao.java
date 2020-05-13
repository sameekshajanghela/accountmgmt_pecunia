package com.capgemini.accountmgmt.dao;
import com.capgemini.accountmgmt.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountDao extends JpaRepository<Account, String> {

}
