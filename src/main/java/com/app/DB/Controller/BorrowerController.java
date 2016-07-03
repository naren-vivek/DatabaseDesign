package com.app.DB.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.DB.serviceImpl.BorrowerManageS;
import com.google.gson.Gson;

@RestController
@RequestMapping("/borrower")
public class BorrowerController {
	
	@Autowired
	BorrowerManageS borrowerManageService;
	
	Gson gson=new Gson();
	
	@RequestMapping(value="/addBorrower", method=RequestMethod.POST)
	public ResponseEntity<String> borrower(
			@RequestParam(required=true) String cardno,
			@RequestParam(required=true) String ssn,
			@RequestParam(required=true) String fname,
			@RequestParam(required=true) String lname,
			@RequestParam(required=true) String address,
			@RequestParam(required=false) String phoneNumber){
		return new ResponseEntity<String>(gson.toJson(borrowerManageService.addBorrower(cardno,fname,lname, ssn, address,phoneNumber)),HttpStatus.OK);
	}
	
	@RequestMapping(value="/fines",method=RequestMethod.GET)
	public ResponseEntity<String> fines(
			@RequestParam(required=true)String fname,
			@RequestParam(required=true)String lname
		){
		//return new ResponseEntity<String>(gson.toJson(borrowerManageService.fine(fname,lname)),HttpStatus.OK);
		return new ResponseEntity<String>(gson.toJson(borrowerManageService.fines(fname,lname)),HttpStatus.OK); 	
	}
	
	@RequestMapping(value="/overdue")
	public ResponseEntity<String> overdue(
			@RequestParam(required=true)String fname,
			@RequestParam(required=true)String lname){
		return new ResponseEntity<String>(gson.toJson(borrowerManageService.getOverdue(fname,lname)),HttpStatus.OK);
	}
	
	/*@RequestMapping(value="/fineEntry")
	public ResponseEntity<String> fineEntry( 
			@RequestParam(required=true)boolean isPaid
			){
		return new ResponseEntity<String>(gson.toJson(borrowerManageService.FinePaid(isPaid)), HttpStatus.OK);
		
		return new ResponseEntity<String>("hello",HttpStatus.OK);
	}*/
}
