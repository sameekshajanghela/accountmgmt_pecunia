package org.cap.accountmgmt.dao;
import org.cap.accountmgmt.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAccountDao extends JpaRepository<Account,String>{

	
	

}
