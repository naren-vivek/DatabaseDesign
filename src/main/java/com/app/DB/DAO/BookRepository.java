package com.app.DB.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.DB.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, String>{
/*
	@Query
	public List<Book> getOverdueBook(String fname,String lname);*/
	
	@Query("select new com.app.DB.Domain.OverDueDomain(b.title) from Book b join b.bookCopies bc join "
			+ "bc.bookLoans bl join bl.borrower bo where bo.cardNo=:cardNo and datediff(bl.dueDate,curdate())<0 and bl.dateIn is null")
	public List<Book> getOverdueBook(@Param("cardNo")String cardNo);
	
	
	
}
