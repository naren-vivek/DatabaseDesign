package com.app.DB.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.DB.serviceImpl.BookLoanS;
import com.google.gson.Gson;

@RestController
@RequestMapping("/bookloan")
public class BookLoans {

/*	@Autowired
	BookLoanS bookLoanService;*/
	
	Gson gson=new Gson();
	
	@RequestMapping(value="/checkin")
	public ResponseEntity<String> checkout(
			@RequestParam(required=true)Date dateOut,
			@RequestParam(required=true)Date dueDate,
			@RequestParam(required=true)String borrower
			){
		/*if(bookLoanService.numOfBooks(borrower)<= 3){
			return new ResponseEntity<String>(
					gson.toJson(bookLoanService.checkOut(dateOut, dueDate, borrower)),HttpStatus.OK);
		}else{
			return new ResponseEntity<String>(
					gson.toJson("More no of books borrowed"),HttpStatus.BAD_REQUEST);
		}*/
		return null;
	}
	
	@RequestMapping(value="/checkout")
	public ResponseEntity<String> checkin(
		@RequestParam(required=true)String borrower,
		@RequestParam(required=true) String bookname
			){
			/*return new ResponseEntity<String>(
					gson.toJson(bookLoanService.checkIn(borrower, bookname)),HttpStatus.OK);*/
		return null;
		
	}
	
}
