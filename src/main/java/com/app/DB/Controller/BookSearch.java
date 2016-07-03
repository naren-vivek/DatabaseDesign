package com.app.DB.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.DB.model.Book;
import com.app.DB.serviceImpl.BookSearchS;
import com.google.gson.Gson;

@RestController
@RequestMapping("/bookSearch")
public class BookSearch {

	@Autowired
	BookSearchS bookSearch;
	Gson gson=new Gson();

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Book>> bookSearch( 
			//@RequestParam(required=true)String libraryBranch,
			@RequestParam String field,
			@RequestParam String branch
			)throws Exception{
		
		List<Book> books = bookSearch.search(field,branch);
		//return books;
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
		
	}

}
