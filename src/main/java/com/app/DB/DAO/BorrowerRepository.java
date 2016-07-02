package com.app.DB.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.DB.model.Borrower;

@Repository
public interface BorrowerRepository extends CrudRepository<Borrower, String> {

	
	/*@Query("inset into Borrower values (l) ")
	public Borrower saveBorrower(String fname,String lname,String ssn,String address);*/
}
