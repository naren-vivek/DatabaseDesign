package com.app.DB.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.DB.model.Fine;

@Repository
public interface FineRepository extends CrudRepository<Fine, String>{

	@Query("select f.fineAmt, f.paid from Fine f join f.bookLoan loan join loan.borrower b "
			+ "where b.fname=?1 and b.lname=?2")
	public Fine getFines(String fname,String lname);
	
	@Query(value="select * from fines",nativeQuery=true)
	public Fine getFine();
}
