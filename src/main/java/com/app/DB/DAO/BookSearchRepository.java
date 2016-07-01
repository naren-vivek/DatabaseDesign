package com.app.DB.DAO;

import java.util.List;

import org.hibernate.annotations.NamedNativeQueries;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.DB.model.Book;

@Repository
public interface BookSearchRepository extends CrudRepository<Book, String>{

	/*@Query("from Book bk "
			+ " where bk.isbn=:value or bk.title=:value")\*/
	@NamedNativeQueries("select * from book")
	public List<Book> searchBooks(@Param("value")String value);
}
