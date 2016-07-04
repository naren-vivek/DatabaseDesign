package com.app.DB.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DB.DAO.BookSearchRepository;
import com.app.DB.model.Book;

@Service
public class BookSearchS {

	@Autowired
	BookSearchRepository bookSearchRepository;

	public List<Book> search(String value, int branch) {
		// TODO Auto-generated method stub

		List<Book> search = bookSearchRepository.searchBooks(value.toLowerCase(), branch);
		return search;
	}

}
