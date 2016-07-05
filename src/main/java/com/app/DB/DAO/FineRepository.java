package com.app.DB.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.DB.model.Fine;

@Repository
public interface FineRepository extends CrudRepository<Fine, String>{

	@Query("select new com.app.DB.Domain.FineDomain(f.loanId,f.fineAmt,f.paid) from Fine f join f.bookLoan loan join loan.borrower b "
			+ "where b.cardNo=:cardNo and f.paid=0")
	public List<Fine> getFinesUnpaid(@Param("cardNo")String cardNo);
	

	@Query("select new com.app.DB.Domain.FineDomain(f.loanId,f.fineAmt,f.paid) from Fine f join f.bookLoan loan join loan.borrower b "
			+ "where b.cardNo=:cardNo and f.paid=1")
	public List<Fine> getFinesPaid(@Param("cardNo")String cardNo);
	
	@Query("select new com.app.DB.Domain.FineDomain(f.loanId,f.fineAmt,f.paid) from Fine f join f.bookLoan loan join loan.borrower b "
			+ "where b.cardNo=:cardNo")
	public List<Fine> getFinesBoth(@Param("cardNo")String cardNo);
	
	
	@Modifying
	@Query("update Fine f set f.paid=1, f.fineAmt=0 where f.loanId=?1")
	public void FineEntry(int loanId);
	
}
