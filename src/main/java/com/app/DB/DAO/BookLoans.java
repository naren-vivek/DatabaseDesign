package com.app.DB.DAO;

import org.springframework.data.repository.CrudRepository;

import com.app.DB.model.BookLoan;

public interface BookLoans extends CrudRepository<BookLoan,Integer>{

	
}
