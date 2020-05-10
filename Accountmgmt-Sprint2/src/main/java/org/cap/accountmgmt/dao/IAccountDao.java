package org.cap.accountmgmt.dao;
import org.cap.accountmgmt.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface IAccountDao extends JpaRepository<Account,String>{

	
	

}
