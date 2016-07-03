package com.app.DB.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.DB.model.Book;

@Repository
public interface BookSearchRepository extends CrudRepository<Book, String> {

	/*
	 * @Query("from Book bk " + " where bk.isbn=:value or bk.title=:value")
	 */
	@Query("select b.isbn,b.title,a.name from Book b join"
			+ " b.authors a where a.name like %?1% or b.isbn like %?1% or b.title like %?1%")
	public List<Book> searchBooks(String value,String branch);
}
