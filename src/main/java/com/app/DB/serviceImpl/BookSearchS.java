package com.app.DB.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DB.DAO.BookSearchRepository;
import com.app.DB.Domain.BookDomain;

@Service
public class BookSearchS {

	@Autowired
	BookSearchRepository bookSearchRepository;

	/*public List<BookDomain> search(String isbn,String title,String author, int branch) {
		// TODO Auto-generated method stub

		List<BookDomain> search = bookSearchRepository.searchBooks(isbn.toLowerCase(),title.toLowerCase(),author.toLowerCase(), branch);
		return search;
	}*/

	public List<BookDomain> search(String common, int branch) {
		// TODO Auto-generated method stub

		List<BookDomain> search = bookSearchRepository.searchBooks(common, branch);
		return search;
	}
}
