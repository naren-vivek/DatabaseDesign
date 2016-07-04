package com.app.DB.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.DB.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, String>{
/*
	@Query
	public List<Book> getOverdueBook(String fname,String lname);*/
	
	@Query("select b.title from Book b join b.bookCopies bc join "
			+ "bc.bookLoans bl join bl.borrower bo where bo.fname=?1"
			+ " and bo.lname=?2 and datediff(bl.dueDate,curdate())<0 and dateIn is null")
	public List<Book> getOverdueBook(String fname, String lname);
	
	
	
}
