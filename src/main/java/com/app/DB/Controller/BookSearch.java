package com.app.DB.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.DB.Domain.BookDomain;
import com.app.DB.serviceImpl.BookSearchS;
import com.google.gson.Gson;

@RestController
@RequestMapping("/bookSearch")
public class BookSearch {

	@Autowired
	BookSearchS bookSearch;
	Gson gson = new Gson();

	@RequestMapping(value="/search",method = RequestMethod.GET)
	public ResponseEntity<List<BookDomain>> bookSearch(
			// @RequestParam(required=true)String libraryBranch,
			/*@RequestParam(required = false) String isbn,
			@RequestParam(required = false) String title,
			@RequestParam(required = false) String author,*/
			@RequestParam(required = false) String common,
			@RequestParam(required = false) int branch) throws Exception {

		List<BookDomain> books = bookSearch.search(common, branch);
		// return books;
		
		return new ResponseEntity<List<BookDomain>>(books, HttpStatus.OK);

	}

}
