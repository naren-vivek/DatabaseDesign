package com.app.DB.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.DB.model.Book;

@Repository
public interface BookSearchRepository extends CrudRepository<Book, String>{

	/*@Query("from Book bk "
			+ " where bk.isbn=:value or bk.title=:value")*/
	@Query(value="select b.isbn,b.title,a.name from book b natural join"
+" book_authors ba natural join authors a where a.name like '%will%' or b.isbn like '%will%'"
+" or b.title like '%will%'")
	public List<Book> searchBooks(@Param("value")String value);
}
