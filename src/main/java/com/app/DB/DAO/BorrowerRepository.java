package com.app.DB.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.DB.model.Borrower;

@Repository
public interface BorrowerRepository extends CrudRepository<Borrower, String> {

	@Query("select count(*) from Borrower where ssn=:ssn")
	public int isSsnValid(@Param("ssn")String ssn);
}
