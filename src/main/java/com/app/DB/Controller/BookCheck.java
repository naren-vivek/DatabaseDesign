package com.app.DB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.DB.serviceImpl.BookLoanS;
import com.google.gson.Gson;

@RestController
@RequestMapping("/bookloan")
public class BookCheck {

	@Autowired
	BookLoanS bookLoanService;
	
	Gson gson=new Gson();
	
	@RequestMapping(value="/checkout", method=RequestMethod.POST)
	public ResponseEntity<String> checkout(
			@RequestParam(required=true)String cardNo,
			@RequestParam(required=true)int bookId
			){

			String check=bookLoanService.checkOut(cardNo,bookId);
			if(check.equals("success")){
				return new ResponseEntity<String>(gson.toJson(check),HttpStatus.OK);
			}
			else{
				return new ResponseEntity<String>(gson.toJson(check),HttpStatus.BAD_REQUEST);
			}
	}
	
	@RequestMapping(value="/checkin", method=RequestMethod.POST)
	public ResponseEntity<String> checkin(
		@RequestParam(required=true)String cardNo,
		@RequestParam(required=true) int bookId
			){
			return new ResponseEntity<String>(gson.toJson(bookLoanService.checkIn(cardNo,bookId)),HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/getActiveBooksCardNum", method=RequestMethod.GET)
	public ResponseEntity<String> activeBooksCard(
			@RequestParam(required=true)String cardNo
			){
		return new ResponseEntity<String>(gson.toJson(bookLoanService.getActiveBooksCardNum(cardNo)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/getActiveBooks", method=RequestMethod.GET)
	public ResponseEntity<String> activeBooks(
			@RequestParam(required=true)String isbn
			){
		return new ResponseEntity<String>(gson.toJson(bookLoanService.getActiveBooks(isbn)),HttpStatus.OK);
	}
	
}