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
			@RequestParam(required=true)String fname,
			@RequestParam(required=true)String lname,
			@RequestParam(required=true)String cardNo,
			@RequestParam(required=true)int bookId
			){

			return new ResponseEntity<String>(gson.toJson(bookLoanService.checkOut(fname,lname,cardNo,bookId)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/checkin", method=RequestMethod.POST)
	public ResponseEntity<String> checkin(
		@RequestParam(required=true)String borrower,
		@RequestParam(required=true) String bookname
			){
			/*return new ResponseEntity<String>(
					gson.toJson(bookLoanService.checkIn(borrower, bookname)),HttpStatus.OK);
		*/
		return null;
	}
	
}