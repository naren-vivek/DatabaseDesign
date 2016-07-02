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
}