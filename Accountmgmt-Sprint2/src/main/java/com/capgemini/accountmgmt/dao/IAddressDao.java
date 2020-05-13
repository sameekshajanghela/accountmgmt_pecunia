package com.capgemini.accountmgmt.dao;

import com.capgemini.accountmgmt.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressDao extends JpaRepository<Address, String> {

}
