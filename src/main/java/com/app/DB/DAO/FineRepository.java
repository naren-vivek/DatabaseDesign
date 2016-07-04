package com.app.DB.DAO;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.DB.model.Fine;

@Repository
public interface FineRepository extends CrudRepository<Fine, String>{

	@Query("select sum(f.fineAmt) from Fine f join f.bookLoan loan join loan.borrower b "
			+ "where b.fname=?1 and b.lname=?2 and f.paid=0")
	public float getFines(String fname,String lname);
	
	@Modifying
	@Query("update Fine f set f.paid=1 where loanId=(select bl.loanId from"
			+ " BookLoan bl where bl.bookId=?1)")
	public void FineEntry(String bookId);
	
}
