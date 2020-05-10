package org.cap.accountmgmt.dao;
import org.cap.accountmgmt.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressDao extends JpaRepository<Address, String> {

}
