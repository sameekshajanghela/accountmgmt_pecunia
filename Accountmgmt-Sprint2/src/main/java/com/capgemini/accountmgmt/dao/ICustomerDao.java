package com.capgemini.accountmgmt.dao;

import com.capgemini.accountmgmt.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerDao extends JpaRepository<Customer, String> {

}
