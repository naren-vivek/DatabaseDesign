package com.app.DB.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.DB.model.Fine;

@Repository
public interface FineRepository extends CrudRepository<Fine, String>{

	@Query(value="select fine_amt,paid from fines f join book_loans b on f.loan_id=b.loan_id join borrower bo "
			+ "on b.card_no=bo.card_no where fname=?1 and lname=?2",nativeQuery=true)
	public Fine getFines(String fname,String lname);
}
